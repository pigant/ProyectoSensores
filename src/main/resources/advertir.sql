-- Function: advertir()

-- DROP FUNCTION advertir();

CREATE OR REPLACE FUNCTION advertir()
  RETURNS trigger AS
$BODY$
valor = TD['new']['valor']
id_tag = TD['new']['id_tag']
plpy.info('Valor crudo: valor=%s id_tag=%s' %(valor, id_tag))
plan = plpy.prepare("\
    select s.id_sensor from sensor as s \
    join tag as t on s.id_sensor=t.id_sensor \
    join historial as h on t.id_tag=h.id_tag \
    where h.id_tag=$1 LIMIT 1", ["integer"])
rv = plpy.execute(plan, [id_tag])
id_sensor = rv[0]['id_sensor']
plpy.info("Id de sensor: %s Valor: %s" % (id_sensor, valor))
valor = plpy.execute("select transformar(%s, %s)" % (valor, id_sensor))[0]['transformar']
plan = plpy.prepare("select max, min from advertencia where id_sensor=$1", ["integer"])
rv = plpy.execute(plan, [id_sensor])
if len(rv) > 0:
    max = rv[0]['max']
    min = rv[0]['min']
    plpy.execute("select log(%s, %s, %s, %s)" % (id_sensor, valor, min, max))
$BODY$
  LANGUAGE plpython3u VOLATILE
  COST 100;
ALTER FUNCTION advertir()
  OWNER TO postgres;
