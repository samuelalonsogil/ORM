INSERT INTO Clientes(clDNI, clNombre, clApellidos, clDireccion, clTelefono, clNumTarjeta) VALUES
('1234678A','María','García Barrenechea','Principe, 38-36201-Vigo','986454545', 123445),
('23456789B','Juan','Santos Gutierrez','Hispanidad, 32-36203-Vigo','986757471', 256654),
('34567890C','Pedro','Astigarraga Marcaide','Pez Volador, 84-28041-Madrid','91565254', 456987),
('45678901D','Marta','Berraondo Ojanguren','Diagonal, 125-23045-Barcelona','93828148', 963258),
('56789012E','Isabel','Ormaechea Garate','Plaza de Galicia, 2-31254-Santiago de Compostela','981232526', 741258),
('67890123F','Carmen','Chinchetru Ochoa','Ronda de Sobradiel,16-28080-Madrid','91656463', 987456),
('78901234G','Iciar','Aguirre Guisasola','Jardines, 17-20020-Eibar','943178545', 456985),
('89012345H','Santiago','Arrieta Andonegui','Marquiegui,10-24561-Deba','943522116', 357753),
('90123456I','Carlos','Barret Sanjurjo','García Barbón, 4-36201-Vigo','986705060', 159951),
('10234567J','Nicolas','Fernández Santos','Rosalía Castro, 14-36201-Vigo','986414243', 125521),
('11345678K','Margarita','Pastoriza Pereira','Camelias, 23-36205-Vigo','986959493', 745547),
('12456789L','Jorge','Sobrina Santos','Serafín Avendaño, 4-36201-Vigo','986525758', 845854);

INSERT INTO Aeropuertos (aeCodigo, aeNombre, aeLocalidad, aePais) VALUES
(100, 'Aeropuerto de Vigo', 'Vigo', 'España'),
(101, 'Aeropuerto de Madrid - Barajas', 'Madrid', 'España'),
(102, 'Aeropuerto de Bilbao', 'Bilbao', 'España'),
(103, 'Aeropuerto Charles de Gaulle', 'París', 'Francia'),
(104, 'Aeropuerto Heathrow de Londres', 'Londres', 'Reino Unido');

INSERT INTO Aviones (avCodigo, avModelo) VALUES
(500, 'Boeing 747'),
(501, 'Boeing 777'),
(502, 'Airbus A340'),
(503, 'Airbus A330'),
(504, 'McDonnell Douglas MD-80');

INSERT INTO Vuelos (vuCodigo, vuCodAvion, vuFecSalida, vuFecLlegada, vuOrigen, vuDestino) VALUES
(700, 503, CURDATE(), vuFecSalida, 100, 102),
(701, 502, CURDATE(), vuFecSalida, 100, 104),
(702, 503, '2020-05-03', vuFecSalida, 100, 104),
(703, 502, '2020-10-03', vuFecSalida, 100, 103),
(800, 500, adddate(CURDATE(), INTERVAL 1 DAY), vuFecSalida, 100, 101),
(801, 501, adddate(CURDATE(), INTERVAL 1 DAY), vuFecSalida, 100, 102),
(802, 500, adddate(CURDATE(), INTERVAL 2 DAY), vuFecSalida, 100, 101),
(803, 501, adddate(CURDATE(), INTERVAL 2 DAY), vuFecSalida, 100, 102);

INSERT INTO Asientos (asCodigo, asCodAvion, asFila, asColumna) VALUES
(1, 500, 1, 1), (2, 500, 1, 2), (3, 500, 2, 1), 
(4, 500, 2, 2), (5, 500, 3, 1), (6, 500, 1, 2),
(7, 501, 1, 1), (8, 501, 1, 2), (9, 501, 2, 1), 
(10, 501, 2, 2), (11, 501, 3, 1), (12, 501, 1, 2),
(13, 502, 1, 1), (14, 502, 1, 2), (15, 502, 2, 1), 
(16, 502, 2, 2), (17, 502, 3, 1), (18, 502, 1, 2),
(19, 503, 1, 1), (20, 503, 1, 2), (21, 503, 2, 1), 
(22, 503, 2, 2), (23, 503, 3, 1), (24, 503, 1, 2),
(25, 504, 1, 1), (26, 504, 1, 2), (27, 504, 2, 1), 
(28, 504, 2, 2), (29, 504, 3, 1), (30, 504, 1, 2);

INSERT INTO TarjetasEmbarque (teCodigo, teDni, teCodAsiento, teCodVuelo) VALUES
(1, '1234678A', 1, 702),
(2, '1234678A', 6, 703),
(3, '1234678A', 18, 701),
(4, '45678901D',2, 702),
(5, '45678901D', 5, 703),
(6, '10234567J', 17, 701),
(7, '10234567J', 3, 702),
(8, '10234567J', 4, 703),
(9, '67890123F', 16, 701);

/*
1º) 
Mostrar el nombre completo del cliente y el nº de viaje realizados (cuantas tarjetas de embarque tiene).
*/
SELECT CONCAT(clApellidos, ", ", clNombre), COUNT(teCodigo)
FROM Clientes JOIN TarjetasEmbarque ON clDni = teDNi 
JOIN Vuelos ON vuCodigo = teCodVuelo
GROUP BY teDNI;




/*
2º) Mostrar los aviones que no hayan realizado ningún vuelo desde la ciudad de Vigo
*/

SELECT aviones.*
FROM Aviones 
WHERE avCodigo NOT IN (SELECT vuCodAvion FROM Vuelos JOIN Aeropuertos ON aeCodigo = vuOrigen
WHERE aeLocalidad = 'Vigo');

/*
3º) Listar los clientes que tienen que salir del aeropuerto de Vigo en una determinada 
fecha que introduciremos por teclado. (Por ejemplo hoy).
*/
SELECT CONCAT(clApellidos, ", ", clNombre)
FROM Clientes JOIN TarjetasEmbarque ON clDni = teDni 
JOIN Vuelos ON teCodVuelo = vuCodigo
JOIN Aeropuertos ON aeCodigo = vuOrigen
WHERE vuFecSalida = CURDATE() AND aeLocalidad = 'Vigo';

SELECT CONCAT(clApellidos, ", ", clNombre)
			FROM Clientes JOIN TarjetasEmbarque ON clDni = teDni 
			JOIN Vuelos ON teCodVuelo = vuCodigo
			JOIN Aeropuertos ON aeCodigo = vuOrigen
			WHERE vuFecSalida = CURDATE() AND aeNombre = 'Aeropuerto de Vigo';


SELECT CONCAT(clApellidos, ", ", clNombre)
FROM Clientes JOIN TarjetasEmbarque ON clDni = teDni 
JOIN Vuelos ON teCodVuelo = vuCodigo
JOIN Aeropuertos ON aeCodigo = vuOrigen
WHERE vuFecSalida = '2020-05-03' AND aeLocalidad = 'Vigo';

/*
4º) Queremos sacar la tarjeta de embarque para el vuelo , para ello introduciremos el aeropuerto y la 
fecha de salida del vuelo. Ocuparemos el primer asiento libre,
actualizaremos las tablas necesarias.

Sacar la tarjeta de embarque para el vuelo Vigo - Bilbao del día 04-02-2021 (Nº vuelo 700); para Iciar Aguirre
Guisasola con DNI 78901234G. Nº Asiento 19 
*/



/*
1º) Para fomentar el turismo se quiere regalar un viaje al cliente o clientes que más viajes 
haya realizado (el que tenga más tarjetas de embarque). 
Mostrar el nombre completo del cliente y el nº de viaje realizados.
*/
SELECT CONCAT(clApellidos, ", ", clNombre), COUNT(teCodigo)
FROM Clientes JOIN TarjetasEmbarque ON clDni = teDNi 
JOIN Vuelos ON vuCodigo = teCodVuelo
GROUP BY teDNI
HAVING COUNT(teCodigo) = 
(SELECT COUNT(teCodigo) as Cuenta FROM TarjetasEmbarque GROUP BY teDNI ORDER BY Cuenta DESC LIMIT 1); 



