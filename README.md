# 🚀 Proyecto Spring Boot - Prueba Técnica

Este proyecto es una aplicación desarrollada en **Spring Boot** 🛠️ que utiliza una base de datos MySQL 🗄️ para almacenar información y expone una serie de endpoints 📡 para su consumo.

---

## ⚙️ Configuración del Proyecto

### 📋 Requisitos Previos
1. **☕ Java**: Asegúrate de tener instalada la versión 17 o superior.
2. **🔧 Maven**: Herramienta de construcción para gestionar las dependencias.
3. **🗄️ MySQL**: Base de datos utilizada para esta prueba.

### 🌐 Configuración de Variables de Entorno
Para configurar las variables de entorno necesarias, sigue estos pasos:

1. Copia el archivo `.env.example` en la raíz del proyecto y renómbralo a `.env`:

   ```bash
   cp .env.example .env
   ```

2. Edita el archivo `.env` con las credenciales y configuraciones necesarias para tu entorno. Ejemplo:

   ```env
   SPRING_APPLICATION_NAME=APP
   DB_URL=jdbc:mysql://localhost:3306/testdb
   DB_USERNAME=root
   DB_PASSWORD=secret
   SERVER_PORT=8080
   ```

### 🗄️ Configuración de la Base de Datos
Los scripts SQL necesarios para crear y poblar la base de datos se encuentran en la carpeta `resources/SQL` 📂.

1. ejecuta:  
   - `testswisslub.sql` 📄

---

## 🗂️ Estructura del Proyecto

### 📂 Carpeta `resources`
- **`SQL`**: Contiene los scripts SQL para la configuración de la base de datos.
- **`postman`**: Contiene la colección de Postman con los endpoints 📡 expuestos por la aplicación.

### 📡 Endpoints
Los endpoints del proyecto están documentados en un archivo Postman que se encuentra en:

```
resources/postman/collection_postman_movimientos.json
resources/postman/collection_postman_movimientos_detalles.json
```

Puedes importar esta colección en Postman 🛠️ para probar los endpoints directamente.

---

## ▶️ Cómo Ejecutar el Proyecto

1. Clona el repositorio:

   ```bash
   git clone https://github.com/cristopher003/prueba-movimientos
   cd prueba-movimientos
   ```

2. Configura las variables de entorno como se explicó anteriormente.

3. Construye el proyecto usando Maven 🔧:

   ```bash
   mvn clean install
   ```

4. Ejecuta la aplicación 🚀:

   ```bash
   mvn spring-boot:run
   ```

---

## 📝 Notas

- Asegúrate de que el puerto configurado en el archivo `.env` no esté en uso.

---

## 📬 Contacto
Para cualquier duda o sugerencia, puedes contactar al desarrollador:

- **👤 Nombre**: Cristopher Solis
- **📧 Correo**: cristophesolis@hotmail.com
- **🌐 GitHub**: [https://github.com/cristopher003](https://github.com/cristopher003)

---

**¡Gracias por revisar este proyecto! 🙌**

