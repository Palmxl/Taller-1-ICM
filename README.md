# Taller 1-ICM

## 👥 Integrantes Grupo SinWifi
- Juan Martín Sánchez Burbano  
- Natalia Ramirez  
- Santiago Saavedra  

## 🎥 Enlace del Video
- https://www.youtube.com/watch?v=aQfqDGqYUL4 

## 📌 Descripción del Taller
Para este taller realizamos una aplicación en **Android Studio** que consiste en lo siguiente:  

- Creamos una actividad principal con tres botones **Explorar Destinos, Favoritos y Recomendaciones** y un **spinner** con seis categorías de viajes: *Todos, Playas, Montañas, Ciudades Históricas, Maravillas del Mundo y Selvas*.  
- Al pulsar el botón **Explorar Destinos**, se abre una nueva actividad que muestra una lista de destinos turísticos cargados desde un archivo **JSON**. Esta lista se filtra según la categoría seleccionada en el spinner.  
- Si se selecciona un destino, se abre otra actividad con todos los detalles del mismo y un botón para añadirlo a la lista de favoritos. Una vez añadido, el botón se desactiva y aparece un **Toast** con el mensaje *“Añadido a favoritos”*.  
- El botón **Favoritos** muestra la lista completa de los destinos que fueron marcados como favoritos.  
- El botón **Recomendaciones** abre una actividad que muestra un destino aleatorio de los favoritos que pertenezca a la categoría más frecuente. Si no hay favoritos, se muestra el valor **NA**.  
- Como funcionalidad adicional , agregamos la posibilidad de mostrar el clima actual del destino seleccionado utilizando una API gratuita.  

De esta manera, la aplicación integra el manejo de actividades, listas, filtros, listeners, almacenamiento temporal y consumo de datos externos, cumpliendo con todos los puntos planteados en el taller.  


