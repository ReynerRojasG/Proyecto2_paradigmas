# Sistema de Planilla Quincenal

**Participantes del proyecto:**  
- Makin Artavia Zúñiga  
- Cipriano Rivera Escobar  
- Reyner Rojas Gutiérrez  

El sistema calcula la planilla quincenal de distintos tipos de empleados y aplica bonificaciones mediante estrategias de incentivo. Está diseñado usando herencia, interfaces y polimorfismo, respetando LSP y facilitando OCP.

---

## 1. Organización del código

**Paquetes y responsabilidades:**

- `app`: punto de entrada (`Proyecto2.java`).  
- `modelo`: jerarquía de empleados, interfaz `Bonificable`, estrategias de `Incentivo`.  
- `servicios`: lógica de planilla (`Planilla.java`).  
- `infra`: utilidades de lectura/escritura CSV (`FileManager.java`).  

**Archivos principales:**  
`Empleado.java`, `Asalariado.java`, `PorHora.java`, `Temporal.java`, `Comisionista.java`, `Practicante.java`, `Bonificable.java`, `Incentivo*.java`, `Planilla.java`, `FileManager.java`, `Proyecto2.java`.

---

## 2. Descripción de clases

- **Empleado:** clase abstracta con `cedula`, `nombre`, `salarioXquincena`, `incentivo` y `aniosServicio`. Define `salarioQuicena()` y `bono()`.  
- **Bonificable:** interfaz para exponer bono polimórfico.  
- **Incentivo / Estrategias:** calcula el bono según tipo (`Antiguedad`, `Desempeno`, `Productividad`). Facilita OCP.  

**Subclases de Empleado:**  
- `Asalariado`: salario mensual / 2.  
- `PorHora`: tarifaHora × horasQuincena.  
- `Temporal`: tarifaDiaria × diasActivos.  
- `Comisionista`: base + porcentaje × ventasQuincena.  
- `Practicante`: solo apoyoQuincena, registro independiente.  

**Servicios y utilidades:**  
- `Planilla`: calcula `salarioQuicena`, aplica bono polimórfico y muestra pago final.  
- `FileManager`: maneja CSV, evita duplicados, crea carpetas `data/` y `out/`, exporta planilla consolidada.

---

## 3. Flujo de ejecución

1. `Proyecto2` instancia empleados y asigna estrategias de incentivo.  
2. `FileManager` guarda registros y carga lista homogénea de empleados.  
3. `Planilla.pago` calcula salario base, bono y total por polimorfismo.  
4. `FileManager.guardarPlanilla` exporta CSV final (`out/planilla_quincena.csv`).  

---

## 4. Cálculo de planilla

- **Salario base:** definido por cada subclase (`salarioQuicena`).  
- **Bono:** delegado al `Incentivo` asociado.  
- **Total a pagar:** `salarioQuicena + bono`.

---

## 5. Persistencia CSV

**Entrada:** `data/empleados.csv` con campos según tipo de empleado.  

**Salida:** `out/planilla_quincena.csv` con columnas:  
