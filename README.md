 # Итоговая контрольная работа
## Информация о проекте
Необходимо организовать систему учета для питомника в котором живут
домашние и вьючные животные.

Задание
1. Используя команду `cat` в терминале операционной системы Linux, создать
   два файла Домашние животные (заполнив файл собаками, кошками,
   хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и
   ослы), а затем объединить их. Просмотреть содержимое созданного файла.
   Переименовать файл, дав ему новое имя (Друзья человека).

````commandline
 dmitriy@Demin-VM:~$  cat > Pets
 собака 1
 кот 1
 собака 2
 собака 3
 хомяк 1
 кот 2
````
````commandline
 dmitriy@Demin-VM:~$ cat > Pack_animals
 лошадь 1
 лошадь2
 осел 1
 верблюд 1
 верблюд 2
 верблюд 3
````
````commandline 
  dmitriy@Demin-VM:~$ ls -al
````
````commandline
вывод
-rw-rw-r--  1 dmitriy dmitriy    74 сен  9 20:48  Pack_animals
-rw-rw-r--  1 dmitriy dmitriy    67 сен  9 20:46  Pets
````
````commandline
   dmitriy@Demin-VM:~$ cat Pack_animals Pets > Human_friends
   dmitriy@Demin-VM:~$ ls -al

````
````commandline
вывод
-rw-rw-r--  1 dmitriy dmitriy   141 сен  9 20:54  Human_friends
-rw-rw-r--  1 dmitriy dmitriy    74 сен  9 20:48  Pack_animals
-rw-rw-r--  1 dmitriy dmitriy    67 сен  9 20:46  Pets
````
2. Создать директорию, переместить файл туда.
````commandline
   dmitriy@Demin-VM:~$ mkdir AniamalNursery
   dmitriy@Demin-VM:~$ mv Humad_friends AniamalNursery/
````
````commandline
итого 12
drwxrwxr-x  2 dmitriy dmitriy 4096 сен  9 21:52 .
drwxr-x--- 25 dmitriy dmitriy 4096 сен  9 21:52 ..
-rw-rw-r--  1 dmitriy dmitriy  141 сен  9 20:54 Human_friends
````
3. Подключить дополнительный репозиторий MySQL. Установить любой пакет
   из этого репозитория.
   Для подключения дополнительного репозитория необходимо добавить конфигационный файл
с адресом добавляемого репо в директорию `/etc/apt/ources.list.d` после чего добавить 
ключ репозитория для подтверждения безопасности.
```commandline
dmitriy@Demin-VM:/etc/apt/sources.list.d$ ls -al
итого 24
drwxr-xr-x 2 root root 4096 авг 26 22:14 .
drwxr-xr-x 9 root root 4096 июл 21 17:56 ..
-rw-r--r-- 1 root root  112 авг 13 19:35 docker.list
-rw-r--r-- 1 root root  650 авг 26 19:11 mysql.list
-rw-r--r-- 1 root root  386 июл 21 17:56 ubuntu.sources
-rw-r--r-- 1 root root 2552 апр 24 14:51 ubuntu.sources.curtin.orig
```




4. Установить и удалить deb-пакет с помощью dpkg.
   Скачайте deb-пакет. Например, мы будем устанавливать vivaldi.
```commandline
   dmitriy@Demin-VM:~$ wget -E https://downloads.vivaldi.com/stable/vivaldi-stable_6.9.3447.41-1_amd64.deb
   dmitriy@Demin-VM:~$ sudo dpkg -i vivaldi-stable_6.9.3447.41-1_amd64.deb
   dmitriy@Demin-VM:~$ sudo dpkg -r vivaldi-stable
   ```
5. Выложить историю команд в терминале ubuntu
6. Нарисовать диаграмму, в которой есть класс родительский класс, домашние
   животные и вьючные животные, в составы которых в случае домашних
   животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные
   войдут: Лошади, верблюды и ослы).

![alt text](\images\classDiagram.jpg)

7. В подключенном MySQL репозитории создать базу данных “Друзья
   человека”


8. Создать таблицы с иерархией из диаграммы в БД
9. Заполнить низкоуровневые таблицы именами(животных), командами
   которые они выполняют и датами рождения
10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
    питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.
    11.Создать новую таблицу “молодые животные” в которую попадут все
    животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
    до месяца подсчитать возраст животных в новой таблице
12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
    прошлую принадлежность к старым таблицам.
    13.Создать класс с Инкапсуляцией методов и наследованием по диаграмме.
14. Написать программу, имитирующую работу реестра домашних животных.
    В программе должен быть реализован следующий функционал:
    14.1 Завести новое животное
    14.2 определять животное в правильный класс
    14.3 увидеть список команд, которое выполняет животное
    14.4 обучить животное новым командам
    14.5 Реализовать навигацию по меню
    15.Создайте класс Счетчик, у которого есть метод add(), увеличивающий̆
    значение внутренней̆int переменной̆на 1 при нажатие “Завести новое
    животное” Сделайте так, чтобы с объектом такого типа можно было работать в
    блоке try-with-resources. Нужно бросить исключение, если работа с объектом
    типа счетчик была не в ресурсном try и/или ресурс остался открыт. Значение
    считать в ресурсе try, если при заведения животного заполнены все поля.