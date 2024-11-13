
---

# Todo Application

Este proyecto es una aplicación de consola para gestionar tareas pendientes (Todo) utilizando Java. La aplicación permite a los usuarios crear, ver, actualizar, eliminar y marcar tareas como completadas, almacenándolas en una base de datos SQL Server.

## Estructura del Proyecto

- **`Todo`**: Representa una tarea con un ID, descripción y estado de finalización.
- **`TodoDAO`**: Maneja las operaciones de acceso a datos (CRUD) con la base de datos SQL Server.
- **`TodoCLI`**: Proporciona una interfaz de línea de comandos para interactuar con las tareas.

## Requisitos

- **Java 8+**
- **SQL Server**
- **JDBC Driver para SQL Server**

## Configuración

1. Asegúrate de que SQL Server está en ejecución y que tienes una base de datos llamada `TODO`.
2. Ajusta la URL de conexión en la clase `TodoDAO` si es necesario:
   ```java
   private static final String URL = "jdbc:sqlserver://localhost:1433;database=TODO;integratedSecurity=true;encrypt=false;trustServerCertificate=true;";
   ```

## Uso

Ejecuta la aplicación en la línea de comandos y sigue las instrucciones del menú para gestionar tus tareas.

### Funcionalidades

1. **Crear una tarea**
2. **Ver todas las tareas**
3. **Actualizar una tarea**
4. **Eliminar una tarea**
5. **Marcar una tarea como completada**
6. **Salir**

## Ejemplo de Uso

1. Crear una nueva tarea:
   ```
   Enter todo task: Comprar leche
   ```
2. Ver todas las tareas:
   ```
   Número tarea: 1
   Tarea: Comprar leche
   Completado?: Falso
   ```

## Contribuciones

Las contribuciones son bienvenidas. Crea un *pull request* con tus mejoras o abre un *issue* para sugerencias.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT.

---