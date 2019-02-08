# Aplicación de Mascotas, Generando Persistencia a los Datos

En el siguiente archivo se describira de manera breve las diferentes vistas y acciones que realiza el proyecto.
Este desarrollo es hecho por Diego Sebastian Camargo Lopez, Bogotà, Colombia.

##Para poder comprender como estan relacionados los datos para su correcta visualizacion en la app, se adjunta el siguiente modelo relacional para su debido analisis.

![alt text](https://github.com/essebas/Coursera_Semana5_GenerandoPersistencia/blob/master/img/DiagramaRelacional.png)

## 1. Vista principal, general:

En esta imagen se podra observar lo que el usuario visualiza al ejecutar la aplicacion, haciendo uso de un Toolbar y Tablayout
se logro crear el un menu con dos tabs, una para el home, donde se ven todas las fotos de las mascotas y otra para el perfil
de la mascota. Tambien para hacer posible la interaccion entre pestañas se uso un ViewPager y se crearon dos fragments para 
mostrar la informacion de cada una de las pestañas.

![alt text](https://github.com/essebas/Coursera_Semana4_MenusFragments/blob/master/img/inicio.PNG)


## 2. Vista de pefil mascota, general:

En esta imagen se observa el diseño dellayout para el perfil de la mascota, se integro una libreria para poder hacer que las imagenes
sean redondas. Se implemento un reciclerView para mostrar las fotos de las mascotas y se uso un adaptador diferente al que se usa en la
pestaña de "Home", tambien se creo otro layout que contenia el disño del cardview, pese a que es un diseño similar al que se utiliza en
el inicio, se penso para asegurar la escalabilidad y que sea mas facil editar o actualizar cada componente por independiente.

![alt text](https://github.com/essebas/Coursera_Semana4_MenusFragments/blob/master/img/perfil.PNG)


## 3. Menu de opciones, vista del menu:

Aqui se podra ver la posicion y como se compone el menu de opciones, se encuentra en al appbar de la app.

![alt text](https://github.com/essebas/Coursera_Semana4_MenusFragments/blob/master/img/MenuOpciones.PNG)


## 4. Vista de Contacto, formulario vacio:

Aqui se ve como el usuario visualiza la vista de contacto despues de hacer click en el menu de opciones. Formulario vacio.

![alt text](https://github.com/essebas/Coursera_Semana4_MenusFragments/blob/master/img/ContactoEmpy.PNG)


## 5. Vista de Contacto, formulario lleno, preparando envio de correo:

Se puede observar el formulario lleno, colo los daos solicitados, listo para que el usuario pueda enviar la informacion y
le llegue al administrador del sistema un correo de contacto, que es enviado desde la aplicacion.

![alt text](https://github.com/essebas/Coursera_Semana4_MenusFragments/blob/master/img/ContactoFull.PNG)

## 6. Vista de Contacto, Datos enviados, Notificacion de correo entrante por la aplicacion:

En estas dos imagenes se podra observar lo que el usuario vera en la pantalla al ser enviado el correo de manera exitosa,
 se desplegara un Snackbar notificando el envio y se limpiaran todos los campos del formulario. En la segunda imagen se evidenciara 
 la llegada del correo por medio de una notificacion en un dispositivo real, se puede observar que el nombre y el mensaje que envio
 el usuario son acordes a lo que se evidencia en la notificacion.

![alt text](https://github.com/essebas/Coursera_Semana4_MenusFragments/blob/master/img/correo_enviado.png)
--------------------------------------------------------------
![alt text](https://github.com/essebas/Coursera_Semana4_MenusFragments/blob/master/img/correo_recibido.jpeg)


Para poder hacer que esta funcionalidad se ejecute correctamente, se necesita que la persona que descarge el proyecto ingrese el 
correo y la contraseña de la cuenta que va a salir el correo. Este cambio se debe realizar en la clase SimpleMail.java, que se 
encuentra dentro del paquete Mailer.

![alt text](https://github.com/essebas/Coursera_Semana4_MenusFragments/blob/master/img/example.PNG)

## 7. Vista de Acerca De, informacion del desarrollador:

Aqui se ve como el usuario visualiza la vista de acerca de, despues de hacer click en el menu de opciones.

![alt text](https://github.com/essebas/Coursera_Semana4_MenusFragments/blob/master/img/AcercaDe.PNG)

## 8. Vista de Acerca De, abriendo navegador, intent implicito:

Para este caso, se realizo click en el boton de Twitter, esta funcionalidad permite ver las redes sociales del desarrollador
por medio de FloatingButton.

![alt text](https://github.com/essebas/Coursera_Semana4_MenusFragments/blob/master/img/AcercaDeTwitter.PNG)
