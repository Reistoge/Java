 # <div align="center"> Tarea 1 </div> #
<div align="center"> <img src="https://github.com/Reistoge/Tarea1PatronesDeSoftware/blob/main/images/a_250319_164225_0.png?raw=true" alt="Imagen 1"> <img src="https://github.com/Reistoge/Tarea1PatronesDeSoftware/blob/main/images/a_250319_164225_1.png?raw=true" alt="Imagen 2"> </div> </br>

## Item I.
* Clase `Cliente`: No oculta su información, ya que sus atributos son públicos. Dependiendo del contexto, puede que sea necesario un atributo o registro que almacene la relación que tiene con un hotel, como una clase Reserva.
* Clase `Hotel`: Accede públicamente a los datos de un `Cliente`. `Hotel` debería tener un arreglo de la clase `Cliente` para añadir cada instancia en hacerReserva().
* Los problemas de diseño se enfocan más en el ocultamiento de información, ya que se accede directamente a atributos públicos, y también en la separación de intereses, ya que la clase `Hotel` no debería procesar la reserva.
## Item II y III
* Los cambios realizados se pueden ver [aqui](https://github.com/Reistoge/Tarea1PatronesDeSoftware/tree/main/src) .
* `Main.java` contiene el codigo nuevo y mejorado.
* `ScriptInicial` contiene el codigo inicial del enunciado de la tarea a realizar.
## Item IV
### Clase `Reserva`
* Se agregó la clase `Reserva`, la cual mejora la integridad conceptual y separa los intereses de nuestro programa. Además, debido a la relación que tiene la clase `Reserva`  con `Hotel` y Cliente, tendríamos un acoplamiento adecuado, ya que ocultamos correctamente la información y las funcionalidades de las clases están correctamente encapsuladas.

### Interfaz `MetodoDePagoStrategy`
* Implementa el patrón Strategy, ya que necesitamos realizar distintas formas o estrategias de pago. Está acompañada de las clases PagoConCredito y PagoConDebito, que implementan esta interfaz. Esto aumentaría o mejoraría la integridad conceptual y la separación de intereses, ya que estamos segregando funcionalidades de nuestro programa en interfaces.
### Clase `SistemaBibliotecaSingleton`
* Esta clase implementa el patrón Singleton y opera funciones necesarias para el correcto funcionamiento del programa.
