/********************* PROYECTO CRUD SPRING BOOT Y ANGULAR *********************/

//SOFTWARE
NodeJS -> 'Versión LTS 16.14.2' → choco install nodejs-lts
NPM → 'Versión LTS con NodeJS' → choco install nodejs-lts
Angular → 'Instalar con Chocolatey o NPM' → npm install -g @angular/cli

//CSS
Bootstrap CDN
Font-Awesome CDN




// PASO 1 → GENERAR LA ESTRUCTURA DEL PROYECTO
ng new crudTienda → Crea el esqueleto de la App.

// PASO 2 → INTEGRAR LIBRERIAS Y FRAMEWORKS 
Bootstrap, Font Awesomo, npm, toastr
// PASO 3 → GENERAR LA CLASE PRODUCTO TS
ng generate class models/producto  --skip-tests -> /*Generar la Clase TypeScript producto dentro del directorio models'*/
// PASO 4 → GENERAR LOS COMPONENTES
ng generate component producto/list-producto --skip-tests --flat
ng generate component producto/detalle-producto --skip-tests --flat
ng generate component producto/nuevo-producto --skip-tests --flat
ng generate component-producto/editar-producto --skip-tests --flat
// PASO 5 → GENERAR LOS SERVICIOS
ng generate service service/producto --skip-tests

//PASO 6 → COMPLETAR LA CLASE PRODUCTO
Completar la Clase product.TS

//PASO 7 → SE CODEA EL app.module.ts
Se importa el HttpClientModule y FormsModule y se cambia de posición los Import de los componentes.

//PASO 8 → SE CODEA EL service producto.service.ts
Se implementa los métodos del Controller Backend, es el corazón del Frontend 

//PASO 9 → SE CODEA EL app-routing.module.ts
Se agregan las rutas, Component.






ng serve → Servir el proyecto. → http://localhost:4200/
ng serve --port 4201 → Modificar el puerto a 4201
