# test_sber

## Задание

> Требуется написать веб-приложение "Формирование заданий для выдачи товара". 
> Минимальный функционал обязателен к реализации
> По желанию можно реализовать один или несколько пунктов из дополнительного функционала

_Исходные данные:_

> Склад состоит из n полок и m боксов (безразмерные) на каждой полке. В каждом боксе хранится определенный товар.
> У товара есть артикул и наименование. Нужно самостоятельно придумать и заполнить боксы товарами. 

*Минимальный функционал:*

> Требуется отобразить на веб-странице таблицу с товарами. 


* Сборка проекта при помощи Maven
* Приложение разворачивается на сервере Apache Tomcat 8.5.40

Перед запуском необходимо прописать переменные среды CATALINA_HOME и JAVA_HOME.

Приложение с помощью драйвера JDBC посылает запрос к базе данных sber_test и создает таблицу с полями Article, Name, Shelf и Box.

Параметры соединения хранятся в файле `/src/main/resources/util.properties/`:

```
jdbc.postgresql.driver=org.postgresql.Driver
jdbc.postgresql.url=jdbc:postgresql://localhost:5432/sber_test
jdbc.postgresql.user=root
jdbc.postgresql.password=root
```
После этого запросом заполняются необходимые поля таблицы, затем приложение запрашивает их и выводит содержимое на странице index.jsp

При обращении по ссылке `http://localhost:8080/` выводятся строки, содержащие необходимые данные из таблицы:

<a href="https://imgbb.com/"><img src="https://i.ibb.co/YB4NMkn/table.png" alt="table" border="0"></a>

