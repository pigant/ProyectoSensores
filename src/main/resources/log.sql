-- Function: log(integer, numeric, numeric, numeric)

-- DROP FUNCTION log(integer, numeric, numeric, numeric);

CREATE OR REPLACE FUNCTION log(sensor integer, valor numeric, min numeric, max numeric)
  RETURNS void AS
$BODY$
if valor > max:
    mensaje = 'max'
elif valor < min:
    mensaje = 'min'
else:
    return
p = plpy.prepare("insert into log   \
(mensaje, fecha, activo, id_sensor) \
values ($1, now(), true, $2)",      \
["text", "integer"])
plpy.execute(p, [mensaje, sensor])
$BODY$
  LANGUAGE plpython3u VOLATILE
  COST 100;
ALTER FUNCTION log(integer, numeric, numeric, numeric)
  OWNER TO postgres;
