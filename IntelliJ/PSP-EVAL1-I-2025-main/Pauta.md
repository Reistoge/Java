# Pauta Evaluación I-2025 - Patrones de Software y Programación

## Parte 1: Identificación de patrones (9 pts)

| Criterio | Descripción esperada                                                               | Puntaje |
| -------- | ---------------------------------------------------------------------------------- | ------- |
| 1.1      | Identifica correctamente el patrón Strategy para la lógica de descuentos           | 3 pts   |
| 1.2      | Identifica correctamente el patrón Proxy para acceso controlado a datos del cliente| 3 pts   |
| 1.3      | Identifica correctamente el patrón Singleton para configuración centralizada       | 3 pts   |

## Parte 2: Justificación y principios SOLID (9 pts)

| Criterio | Descripción esperada                                                                 | Puntaje |
| -------- | ------------------------------------------------------------------------------------ | ------- |
| 2.1      | Justificación clara de por qué Strategy es adecuado y qué principios SOLID aplica    | 3 pts   |
| 2.2      | Justificación clara de por qué Proxy es adecuado y qué principios SOLID aplica       | 3 pts   |
| 2.3      | Justificación clara de por qué Singleton es adecuado y qué principios SOLID aplica   | 3 pts   |

1. Strategy:
    1. Responsabilidad Única: Separa el algoritmo del contexto.
    2. Abierto/Cerrado: Nuevas estrategias no requieren modificar código existente.
    3. Liskov: Todas las estrategias pueden usarse sin alterar el contexto.
    4. Segregación de Interfaces: Interfaz simple, específica para estrategias.
    5. Inversión de Dependencias: Contexto depende de abstracción, no de implementación.
2. Proxy:
    1. Responsabilidad Única: Separa responsabilidades.
    2. Abierto/Cerrado: Nuevas funcionalidades sin cambiar el objeto real o base.
    3. Liskov: El proxy se puede usar donde se espera el objeto real.
    4. Segregación de Interfaces: Puede presentar una interfaz común para clientes, aunque no siempre se implementa.
    5. Inversión de Dependencias: Cliente depende de la abstracción, no de la implementación concreta.
3. Singleton:
    1. Responsabilidad Única: Mezcla lógica de negocio con control de instancia.
    2. Abierto/Cerrado: Dificil de extender o sustituir ya que es rígido.
    3. Liskov: Podría cumplir si usa una interfaz.
    4. Segregación de Interfaces: No suele usar interfaces separadas.
    5. Inversión de Dependencias: Clases dependientes acceden directamente a una implementación concreta.

---

## Parte 3: Implementación del Patrón Strategy (30 pts)

| Criterio | Descripción esperada                                                                                  | Puntaje |
| -------- | ----------------------------------------------------------------------------------------------------- | ------- |
| 3.1      | Se define una interfaz `EstrategiaDescuento` con un método común para aplicar descuentos              | 4 pts   |
| 3.2      | Se implementan clases concretas para cada tipo de descuento                                           | 6 pts   |
| 3.3      | Se utiliza una lista de estrategias para aplicar descuentos acumulativos                              | 8 pts   |
| 3.4      | `GerenciadorDescuento` aplica estrategias de forma desacoplada (`List<EstrategiaDescuento>`)         | 8 pts   |
| 3.5      | La arquitectura permite añadir nuevas estrategias sin modificar el núcleo del `GerenciadorDescuento` | 4 pts   |

---

## Parte 4: Implementación del Patrón Proxy (30 pts)

| Criterio | Descripción esperada                                                                                          | Puntaje |
| -------- | ------------------------------------------------------------------------------------------------------------- | ------- |
| 4.1      | Se define una interfaz común para el acceso a los datos (e.g., `ClienteDataSource`)                           | 4 pts   |
| 4.2      | Se implementa un proxy (`CargaClienteProxy`) que combina datos desde CSV y base de datos                      | 8 pts   |
| 4.3      | El proxy crea instancias desde el CSV y las unifica con los datos persistentes                                | 6 pts   |
| 4.4      | El acceso a los datos del cliente se realiza exclusivamente a través del proxy                                | 8 pts   |
| 4.5      | El proxy incorpora validaciones o filtros al combinar las fuentes de datos                                    | 4 pts   |

---

## Parte 5: Implementación del Patrón Singleton (12 pts)

| Criterio | Descripción esperada                                                                                | Puntaje |
| -------- | --------------------------------------------------------------------------------------------------- | ------- |
| 5.1      | Se implementa correctamente la clase Singleton (`getInstance()`, constructor privado)               | 4 pts   |
| 5.2      | Implementación del método que retorna la fecha actual del sistema                                   | 2 pts   |
| 5.3      | Encapsula múltiples valores de configuración                                                        | 3 pts   |
| 5.4      | Permite acceso centralizado desde cualquier clase, aunque no se use en `Main.java`                 | 3 pts   |
