# Втора лабораториска вежба по Софтверско инженерство
## Миодраг Ќука, бр. на индекс 233297

##Control Flow Graph
![SI_LAB2 0](https://github.com/miodragkjuka/SI_2024_lab2_233297/assets/135254432/3e43484c-4dea-41da-a886-47672425c408)

###Цикломатска комплексност

Цикломатската комплексност на кодот е 10 , пресмета но по принцип на број на региони.
Тест случаи според критериумот Multiple Condition за условот if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0')
-True & True & True     : item.price = 350; item.discount = 0.25; item.barcode = "0123"
-True & True & False    : item.price = 350; item.discount = 0.25; item.barcode = "1234"
-True & False & X       : item.price = 350; item.discount = -1; item.barcode = "1234"
-False & X & X          : item.price = 200; item.discount = -1; item.barcode = "1234"

### Тест случаи според критериумот Every path
![Capture](https://github.com/miodragkjuka/SI_2024_lab2_233297/assets/135254432/5c6affd5-b26d-4037-8d3c-2e754a5d1ac1)

### Објаснување на напишаните unit tests
Првично ги означив јазлите на CFG, пота го нацртав на Draw.io , ја надјов цикломатската комплексност и ги исполнив барањата за Multiple Condition tests и Every Path conditions. Потоа направив нов проект со build system Gradle и креирав тестови. 
