# Images grid JSON | Сетка изображений JSON
## Задача
Разработать приложение:
 
Приложение должно получать JSON-список ссылок на изображения с сервера по адресу
http://dev-tasks.alef.im/task-m-001/list.php
 
и отображать их в виде таблицы следующим образом:
1) все картинки отображаются квадратными.
2) на телефонах две картинки в ряд, на планшетах три картинки в ряд.
 
Приложение должно
— запускаться на Android начиная с версии 5.0
— поддерживать портретную и альмбомную ориентацию
— иметь любую иконку, отличную от иконки по умолчанию
— при свайпе вниз контент должен обновляться
— при клике на изображение оно должно открыться на весь экран
## Решение
* Retrofit + OkHttp Logging Interceptor + Gson Converter
* Glide
* SwipeRefreshLayout + GridView + custom adapter
* Иконка в Adobe Illustrator:
<img src="https://user-images.githubusercontent.com/62970952/119271015-434fde00-bc08-11eb-961b-6d06c80920dd.jpg" width="50%" height="50%">

### Скриншоты и видео
#### Телефон Realme 7
https://user-images.githubusercontent.com/62970952/119269923-ca01bc80-bc02-11eb-80b8-cc8795cee4cd.mp4

<img src="https://user-images.githubusercontent.com/62970952/119269940-e4d43100-bc02-11eb-9230-2121f1f0c9d7.jpg" width="45%" height="45%"> <img src="https://user-images.githubusercontent.com/62970952/119269945-e7368b00-bc02-11eb-8fec-921f3bd0bc52.jpg" width="45%" height="45%">
<img src="https://user-images.githubusercontent.com/62970952/119269950-ed2c6c00-bc02-11eb-8a2c-e28cb7b631f4.jpg" width="45%" height="45%"> <img src="https://user-images.githubusercontent.com/62970952/119269954-ee5d9900-bc02-11eb-9e2a-c22b0033fa44.jpg" width="45%" height="45%">

#### Планшет Pixel C (эмулятор)
https://user-images.githubusercontent.com/62970952/119269981-1947ed00-bc03-11eb-8b8f-0490782b69ee.mp4

<img src="https://user-images.githubusercontent.com/62970952/119269986-21079180-bc03-11eb-9e9b-bb6244739f3f.png" width="45%" height="45%"> <img src="https://user-images.githubusercontent.com/62970952/119269990-2369eb80-bc03-11eb-87f4-48492d7d5a1d.png" width="45%" height="45%">
<img src="https://user-images.githubusercontent.com/62970952/119269991-2664dc00-bc03-11eb-8052-cfbabc2bf82e.png" width="45%" height="45%"> <img src="https://user-images.githubusercontent.com/62970952/119269995-282e9f80-bc03-11eb-921f-c427f4b0d835.png" width="45%" height="45%">
