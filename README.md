# Proyecto Spring Boot - Prueba Técnica

Este proyecto es una aplicación desarrollada en **Spring Boot** que utiliza una base de datos MySQL para almacenar información y expone una serie de endpoints para su consumo.

---

## Configuración del Proyecto

### Requisitos Previos
1. **Java**: Asegúrate de tener instalada la versión 17 o superior.
2. **Maven**: Herramienta de construcción para gestionar las dependencias.
3. **MySQL**: Base de datos utilizada para esta prueba.

### Configuración de Variables de Entorno
Para configurar proyecto:



 Edita el archivo `application.properties` con las credenciales y configuraciones necesarias para tu entorno. Ejemplo:

   ```
   spring.datasource.url=jdbc:mysql://localhost:3306/testswisslub
    spring.datasource.username=root
    spring.datasource.password=root
   ```

### Configuración de la Base de Datos
Los scripts SQL necesarios para crear y poblar la base de datos se encuentran en la carpeta `resources/SQL`.

1. Crea un esquema en MySQL para el proyecto (por ejemplo: `testswisslub`).
2. Ejecuta los scripts en el siguiente orden:
   - `resources/SQL/testswisslub.sql`

---

## Estructura del Proyecto

### Carpeta `resources`
- **`SQL`**: Contiene los scripts SQL para la configuración de la base de datos.
- **`postman`**: Contiene la colección de Postman con los endpoints expuestos por la aplicación.

### Endpoints
Los endpoints del proyecto están documentados en un archivo Postman que se encuentra en:

```
resources/postman/
```

Puedes importar esta colección en Postman para probar los endpoints directamente.

---

## Cómo Ejecutar el Proyecto

1. Clona el repositorio:

   ```bash
   git clone https://github.com/cristopher003/prueba-movimientos
   ```

2. Configura las variables de entorno como se explicó anteriormente.

3. Construye el proyecto usando Maven:

   ```bash
   mvn clean install
   ```

4. Ejecuta la aplicación:

   ```bash
   mvn spring-boot:run
   ```


---


**¡Gracias por revisar este proyecto!**

