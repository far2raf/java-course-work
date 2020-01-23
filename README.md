# list of bugs:
* При запуске тестов определяется другая директория работы программы (course-work/run а не course-work).
Это мешает всей работе с файлами. На данный момент добавленна дублирующая папка course-work/run/data.
При тестирование все пишется в нее. Кажется это не должно помещать при сдаче работы.
* при запуске сервера на aws не подгружался javafx. Просто удалите два класса с GUI.


# Запуск. 
Весь запуск производится через IDEA. 
## Server
run/src/main/ru/ifmo/java/run/RunServers or ./gradlew run
## GUI
run/src/main/ru/ifmo/java/run/GUI
## Как работает
В Gui слева находится тип изменяемых значений, если выбирается любое поле 
кроме nothing, тогда default значение указанное справа, заменяется последовательно на значения 
из указанного полуинтервала.
## Localhost and other
common/src/main/java/ru/ifmo/java/common/Constant.java
содержит адрес (serverHost), на котором открывается сервер. 
Изначально localhost, там есть комментарий с ip-ком. 

#Отчет с графиками.
./graphics.html
# Примечания
* Кнопка save испортит данные, с которых рисовались графики.
