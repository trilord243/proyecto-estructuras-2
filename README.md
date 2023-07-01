# EliteStay

EliteStay es un software moderno diseñado para la gestión de hoteles y alojamientos. Proporciona una interfaz intuitiva para la gestión de las tareas más comunes de un hotel, desde el registro de clientes hasta el seguimiento de las reservas y la ocupación de las habitaciones. En su núcleo, EliteStay se construye teniendo en cuenta la eficiencia, con optimizaciones en la complejidad de tiempo para operaciones clave.

# Funcionalidades 


## Registro de clientes

Los usuarios pueden registrar a los clientes que se encuentran actualmente hospedados en el hotel. Para esto, se introduce el apellido y el nombre del cliente para obtener el número de la habitación en la que se encuentra alojado. Esta operación está diseñada para ser lo más eficiente posible, con una complejidad de tiempo cercana a O(1).

## Búsqueda de Reservación

Dada la cédula de identidad del cliente, los recepcionistas pueden buscar información sobre la reserva del cliente, en caso de que exista. Esta operación es altamente eficiente con una complejidad de tiempo de O(log N)

## Historial de Habitación

El sistema puede generar una lista de todos los clientes que alguna vez se hospedaron en una habitación específica, proporcionando un historial valioso para el seguimiento y la gestión. Esta funcionalidad utiliza un Árbol Binario de Búsqueda (ABB) para mantener la complejidad de tiempo cercana a O(log N).

## Check-in

Cuando un cliente con reserva llega al hotel, el recepcionista puede asignarle fácilmente una habitación y registrar su entrada en el sistema. Este proceso transforma la reserva del cliente en un registro de huéspedes actual del hotel.

## Check-out

Al final de la estancia del cliente, el recepcionista puede realizar el check-out del cliente en el sistema, liberando la habitación y actualizando el historial de la misma.


