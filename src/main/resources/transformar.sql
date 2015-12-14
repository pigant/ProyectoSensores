-- Function: transformar(numeric, integer)

-- DROP FUNCTION transformar(numeric, integer);

CREATE OR REPLACE FUNCTION transformar(valor numeric, codigo_sensor integer)
  RETURNS numeric AS
$BODY$
from decimal import Decimal
import re
rv = plpy.prepare("select escala \
	from sensor where id_sensor=$1 LIMIT 1",["integer"])
rv = plpy.execute(rv, [codigo_sensor])
escala = rv[0]['escala']
#plpy.info("Escala normal: %s" % escala)
escala = "".join(re.split(r"[a-wyzA-WYZ]", escala))
l = re.findall(r"\d+\.\d+|\d+|[*/+-xX]", escala)
for i in range(len(l)):
    if re.match(r"\d+\.\d+|\d+",l[i]):
        l[i] = "Decimal('%s')" % l[i]
    elif re.match(r"[xX]", l[i]):
        l[i] = "Decimal(str(%s))" % l[i]
escala = "".join(l)     
#plpy.info("Escala semi-formateada: %s" % escala)   
d = {'x':valor, 'Decimal': Decimal}
plpy.info("Escala formateada: %s" % escala)
v = eval(escala, d)
return v
$BODY$
  LANGUAGE plpython3u VOLATILE
  COST 100;
ALTER FUNCTION transformar(numeric, integer)
  OWNER TO postgres;
