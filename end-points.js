Endpoint: POST /api/movimientos

json
Copiar código
{
  "descripcion": "Movimiento de prueba 1",
  "idEmpresa": 1001,
  "bodegaOrigenCodigo": "BOD-01",
  "bodegaDestinoCodigo": "BOD-02",
  "fechaCreacion": "2024-12-10T10:00:00",
  "fechaEntrega": "2024-12-17T10:00:00",
  "estado": "P"
}
2. MovimientoDetalle - Ejemplo de petición para crear un detalle de movimiento
Endpoint: POST /api/movimientos/{movimientoId}/detalles

json
Copiar código
{
  "itemCodigo": "ITEM-001",
  "cantidadEnviada": 10
}
3. Movimiento - Ejemplo de petición para actualizar un movimiento
Endpoint: PUT /api/movimientos/{movimientoId}

json
Copiar código
{
  "descripcion": "Movimiento actualizado",
  "idEmpresa": 1001,
  "bodegaOrigenCodigo": "BOD-03",
  "bodegaDestinoCodigo": "BOD-04",
  "fechaCreacion": "2024-12-10T10:00:00",
  "fechaEntrega": "2024-12-17T10:00:00",
  "estado": "T"
}
4. MovimientoDetalle - Ejemplo de petición para actualizar un detalle de movimiento
Endpoint: PUT /api/movimientos/{movimientoId}/detalles/{detalleId}

json
Copiar código
{
  "itemCodigo": "ITEM-001",
  "cantidadEnviada": 15
}
5. Movimiento - Ejemplo de petición para obtener un movimiento por ID
Endpoint: GET /api/movimientos/{movimientoId}

json
Copiar código
{
  "id": 1,
  "descripcion": "Movimiento de prueba 1",
  "idEmpresa": 1001,
  "bodegaOrigenCodigo": "BOD-01",
  "bodegaDestinoCodigo": "BOD-02",
  "fechaCreacion": "2024-12-10T10:00:00",
  "fechaEntrega": "2024-12-17T10:00:00",
  "estado": "P"
}
6. MovimientoDetalle - Ejemplo de petición para obtener detalles de un movimiento
Endpoint: GET /api/movimientos/{movimientoId}/detalles

json
Copiar código
[
  {
    "id": 1,
    "itemCodigo": "ITEM-001",
    "cantidadEnviada": 10
  },
  {
    "id": 2,
    "itemCodigo": "ITEM-002",
    "cantidadEnviada": 20
  }
]
7. MovimientoDetalle - Ejemplo de petición para obtener detalles de un movimiento por estado
Endpoint: GET /api/movimientos/{movimientoId}/detalles/estado/{estado}

json
Copiar código
[
  {
    "id": 1,
    "itemCodigo": "ITEM-001",
    "cantidadEnviada": 10
  },
  {
    "id": 2,
    "itemCodigo": "ITEM-002",
    "cantidadEnviada": 20
  }
]
8. Movimiento - Ejemplo de petición para buscar movimientos por estado
Endpoint: GET /api/movimientos/estado/{estado}

json
Copiar código
[
  {
    "id": 1,
    "descripcion": "Movimiento de prueba 1",
    "idEmpresa": 1001,
    "bodegaOrigenCodigo": "BOD-01",
    "bodegaDestinoCodigo": "BOD-02",
    "fechaCreacion": "2024-12-10T10:00:00",
    "fechaEntrega": "2024-12-17T10:00:00",
    "estado": "P"
  },
  {
    "id": 2,
    "descripcion": "Movimiento de prueba 2",
    "idEmpresa": 1002,
    "bodegaOrigenCodigo": "BOD-03",
    "bodegaDestinoCodigo": "BOD-04",
    "fechaCreacion": "2024-12-10T10:00:00",
    "fechaEntrega": "2024-12-17T10:00:00",
    "estado": "P"
  }
]
// 9. MovimientoDetalle - Ejemplo de petición para obtener detalles específicos
// Endpoint: GET /api/movimientos/detalles/{detalleId}


{
  "id": 1,
  "movimientoId": 1,
  "itemCodigo": "ITEM-001",
  "cantidadEnviada": 10
}

// 10. Movimiento - Ejemplo de petición para obtener estructura personalizada de movimiento y detalles
// Endpoint: GET /api/movimientos/detalles/estructura


[
  {
    "movimientoId": 1,
    "movimientoDetalleId": 1,
    "bodegaOrigenCodigo": "BOD-01",
    "empresa": "Empresa 1001",
    "bodegaDestinoCodigo": "BOD-02",
    "itemCodigo": "ITEM-001"
  },
  {
    "movimientoId": 1,
    "movimientoDetalleId": 2,
    "bodegaOrigenCodigo": "BOD-01",
    "empresa": "Empresa 1001",
    "bodegaDestinoCodigo": "BOD-02",
    "itemCodigo": "ITEM-002"
  }
]