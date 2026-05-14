# 🌳 Árbol Binario de Búsqueda (BST) — Java

Evaluación Final del curso de Estructuras de Datos desarrollado en Java puro, implementando desde cero un Árbol Binario de Búsqueda (BST) sin utilizar librerías nativas de árboles.

---

# 📋 Descripción

Un **Árbol Binario de Búsqueda (BST)** es una estructura de datos jerárquica donde cada nodo cumple una regla fundamental:

> - Los valores menores se almacenan en el subárbol izquierdo.
> - Los valores mayores se almacenan en el subárbol derecho.

Gracias a esta organización, las operaciones de búsqueda, inserción y eliminación pueden realizarse de forma eficiente.

---

# 🚀 Tecnologías utilizadas

- Java
- Programación Orientada a Objetos (POO)
- Recursividad
- Git y GitHub

---

# ✅ Funcionalidades

| Operación | Descripción |
|---|---|
| `insert()` | Inserta un nuevo valor respetando las reglas del BST |
| `search()` | Busca un valor dentro del árbol |
| `delete()` | Elimina nodos considerando los 3 casos posibles |
| `inOrder()` | Recorre el árbol en orden ascendente |
| `preOrder()` | Recorre primero la raíz y luego los hijos |
| `postOrder()` | Recorre primero los hijos y luego la raíz |

---

# 📁 Estructura del proyecto

```txt
bst-project-java/
│
├── fichas-tecnicas
│
├── src/
│   ├── Node.java
│   ├── BinarySearchTree.java
│   └── Main.java
│
├── README.md
└── .gitignore
```

### Archivos principales

| Archivo | Función |
|---|---|
| `Node.java` | Representa la estructura de cada nodo |
| `BinarySearchTree.java` | Contiene toda la lógica del BST |
| `Main.java` | Menú interactivo y ejecución principal |

---

# ▶️ Instrucciones de ejecución

## 1. Clonar repositorio

```bash
git clone [URL_DEL_REPOSITORIO]
```

---

## 2. Entrar a la carpeta src

```bash
cd src
```

---

## 3. Compilar archivos

```bash
javac *.java
```

---

## 4. Ejecutar programa

```bash
java Main
```

---

# 🖥️ Menú interactivo

El programa permite interactuar con el árbol en tiempo real mediante consola.

```txt
===== ARBOL BST =====

1. Insertar valor
2. Buscar valor
3. Eliminar valor
4. Mostrar In-Order
5. Mostrar Pre-Order
6. Mostrar Post-Order
7. Salir
```

---

# 🧠 Funcionamiento del BST

## Ejemplo de inserción

Insertando:

```txt
50, 30, 70, 20, 40
```

Resultado:

```txt
        50
       /  \
      30   70
     /  \
    20   40
```

### Recorrido In-Order

```txt
20 30 40 50 70
```

El recorrido In-Order siempre muestra los valores ordenados de menor a mayor.

---

# ❌ Eliminación de nodos

El método `delete()` implementa los 3 casos fundamentales:

| Caso | Acción |
|---|---|
| Nodo hoja | Se elimina directamente |
| Nodo con un hijo | El hijo reemplaza al nodo |
| Nodo con dos hijos | Se utiliza el sucesor In-Order |

El sucesor In-Order corresponde al valor más pequeño del subárbol derecho.

---

# ⏱️ Complejidad Algorítmica

| Operación | Caso Promedio | Peor Caso |
|---|:---:|:---:|
| Insert | O(log n) | O(n) |
| Search | O(log n) | O(n) |
| Delete | O(log n) | O(n) |
| Traversals | O(n) | O(n) |

---

# ⚠️ Árbol degenerado

Cuando los valores se insertan en orden ascendente o descendente, el árbol pierde balance y puede comportarse como una lista enlazada.

Ejemplo:

```txt
10
 \
  20
    \
     30
       \
        40
```

En este caso, las operaciones pasan de:

```txt
O(log n)
```

a:

```txt
O(n)
```

---

# 🎥 Video
> **Enlace al video:** *[Haz Clic Aquí Para Ver el Video!](https://universidaddavincid-my.sharepoint.com/:v:/g/personal/202503003_estudiante_udv_edu_gt/IQBS3UriUm7fToN8ztyLCnkrAZzpHiV2wSEeFAj3U6-7-64?e=ekxox5&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D)*
---


---

# 👨‍💻 Autor

| Información | Detalle |
|---|---|
| Nombre | Henry Orlando Alonzo Cujcuj |
| Carrera | Ingeniería en Sistemas |
| Universidad | Universidad Da Vinci de Guatemala |
| Curso | Estructuras de Datos |

