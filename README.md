Описание модельной ситуации.
Вы новый сотрудник перспективной инди-гейм-студии «GaMEPhIcation». Ваша компания известна своей успешной игрой – инди-файтингом «Смертельная Битва», и в этом году планирует сделать крупное обновление. К сожалению, изначальный разработчик данной игры больше не работает в Вашей компании, поэтому разработка обновления была поручена Вам. Из материалов разработчика остался git-репозиторий и отчет о выполненных работах, содержащий изначальное ТЗ.

Задание
1.	Ознакомится с отчетом о прошлой работе 
2.	Сделать форк исходного репозитория
3.	Проверить код на работоспособность, в случае неработоспособности кода – восстановить ее
4.	Внести в игру следующие изменения:
a.	В начале игры игрок задает, какое количество локаций он хочет пройти. В каждой локации появляется случайное количество врагов, зависящее от уровня игрока, в финале каждой локации игрока ждет босс
b.	При получении нового уровня игрок должен выбрать какую характеристику он хочет улучшить – урон или максимальное количество здоровья
c.	Добавить новое действие (игроку и противнику-магу) – ослабление противника. Если противник в этот момент уходит в защиту – с вероятностью 75% он получает временный дебаф на n ходов (n – уровень игрока), что увеличивает урон по нему на 25% и сокращает уровень атаки игрока на 50%. Если противник атакует – ослабление срывается, а ослабитель получает дополнительный урон в размере +15%.
d.	Добавить Боссу новое действие – босс в случайный момент боя будет пытаться регенерировать здоровье. Если игрок в этот момент уходит в защиту – босс восстанавливает 50% от полученного на текущий момент урона, если игрок в это время атакует – процесс регенерации прерывается и босс получает двойной урон от атаки игрока.
5.	Компания будет Вам крайне-признательна, если Вы предложите и реализуете более адаптивную систему поведения противников, учитывающую поведение игрока
6.	Так же Вы получите бонус, если оформите документацию на Ваши изменения и основные классы с использованием генератора документации javadoc

Последний комит предыдущего сотрудника - "Дополнительный функционал"

