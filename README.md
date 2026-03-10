# Gestión de Compras en una Tienda Virtual + POO

**Autor:** Miguel David Portillo Padilla

## Descripción

Programa en Java que simula una tienda virtual donde los usuarios pueden comprar productos.  
El sistema utiliza **Programación Orientada a Objetos (POO)** y **ArrayList** para gestionar el catálogo de productos y el carrito de compras.

El programa funciona mediante un menú principal que se repite después de ejecutar cada opción, evitando que el programa finalice hasta que el usuario seleccione la opción "Salir".

## Estructura del Sistema

El programa maneja dos **ArrayList** que almacenan objetos de la clase `Producto`:

- Un **ArrayList** para el catálogo de productos.
- Un **ArrayList** para el carrito de compras.

## Opciones del Menú

1. Mostrar catálogo de productos  
   Al iniciar el programa se muestra la lista de productos disponibles con sus nombres y precios.

2. Agregar productos al carrito  
   El usuario selecciona el número del producto del catálogo y luego indica la cantidad que desea comprar.  
   El sistema permite agregar múltiples productos preguntando si desea continuar agregando más.

3. Ver resumen del carrito  
   Muestra los productos agregados al carrito con:
    - nombre del producto
    - precio unitario
    - cantidad
    - subtotal (precio × cantidad)

   También se muestra el total de la compra sumando todos los subtotales.

4. Agregar productos al catálogo  
   Permite añadir nuevos productos al catálogo ingresando su nombre y precio.

5. Salir  
   Finaliza la ejecución del programa.

## Funcionamiento

- El programa inicia mostrando el catálogo y el menú principal.
- Después de ejecutar cualquier opción, el sistema regresa al menú.
- El programa solo termina cuando el usuario selecciona la opción "Salir".****