# android-application
Дипломная работа.

Разработка приложения для поиска отелей и информации о погоде для пользователей смартфонов на основе платформы «Android». Текущее прило-жение создавалось по требованию заказчика, “Drom.ru” и выполнялось по требованиям. Приложение будет являться основой для дальнейшего развития. Приложение будет ориентироваться на авто-туризм. Когда вы отправляетесь в соседний город на автомобиле вам необходимо просмотреть как минимум не-сколько вариантов гостиниц в городе, а иногда и больше, ведь хорошо всегда лишний раз перестраховаться.
Цель работы — создать рабочую версию приложения в которой будет возможность получения информации об отелях и погоде. 
	Актуальность задачи — предоставить приложение для авто-туризма и перенести приложение на платформу Android-auto, так как на этой платформе мало приложений. 
	Выполнить задачу лучше всего используя готовые сервисы и собрать их в одном приложении. 	
В процессе поиска оптимального решения задачи в рамках проекта изу-чены сервисы  существующих API, и выбраны наиболее оптимальные.
Выделены следующие этапы работы для решения задачи поиска и визу-ализации карты:
­	Установка библиотек.
­	Подготовка среды разработки под сервисы.
­	Выбор структуры данных в программе.
­	Создание окон и интерфейса.
­	Добавление шаблонов проектирования.
­	Реализация методов.
 
1	ПОСТАНОВКА ЗАДАЧИ
Создать программный комплекс, реализующий задачу поиска отелей в выбранном городе.
Интерфейс пользователя должен позволять выбрать город, отобразить отели на карте и показать информацию, так же предоставить информацию о погоде в этом регионе.
Для оптимального решения задачи следует использовать сервисы API и шаблоны проектирования.
Маркеры на карте должны обновляться и рисоваться только когда они находятся в поле видимости пользователя.
Задачу необходимо выполнить используя оптимальные структуры дан-ных.
 
2	ОПИСАНИЕ ПРЕДМЕТНОЙ ОБЛАСТИ

	API определяет функциональность, которую предоставляет программа (модуль, библиотека), при этом API позволяет абстрагироваться от того, как именно эта функциональность реализована.
Если программу (модуль, библиотеку) рассматривать как чёрный ящик, то API — это множество «ручек», которые доступны пользователю данного ящика и которые он может вертеть и дёргать.
Программные компоненты взаимодействуют друг с другом посредством API. При этом обычно компоненты образуют иерархию — высокоуровневые компоненты используют API низкоуровневых компонентов, а те, в свою оче-редь, используют API ещё более низкоуровневых компонентов.
По такому принципу построены протоколы передачи данных по Интер-нет. Стандартный стек протоколов (сетевая модель OSI) содержит 7 уровней (от физического уровня передачи бит до уровня протоколов приложений, по-добных протоколам HTTP и IMAP). Каждый уровень пользуется функцио-нальностью предыдущего («нижележащего») уровня передачи данных и, в свою очередь, предоставляет нужную функциональность следующему («вы-шележащему») уровню.
Практически все операционные системы (UNIX, WINDOWS и т. д.) име-ют API, с помощью которого программисты могут создавать приложения для этой операционной системы. Главный API операционных систем — это мно-жество системных вызовов. 

4	ФУНКЦИОНАЛЬНЫЕ ТРЕБОВАНИЯ К ПРОГРАММНОМУ СРЕДСТВУ
Интерфейс пользователя должен позволять выбрать город, отобразить гостиницы на карте и показать информацию, так же предоставить информа-цию о погоде в этом регионе.
Для данного программного продукта предусмотрен только один уро-вень доступа, т.е. все пользователи имеют доступ ко всем возможностям про-дукта.
5	НЕФУНКЦИОНАЛЬНЫЕ ТРЕБОВАНИЯ К
 ПРОГРАММНОМУ СРЕДСТВУ
5.1	Требования к программному обеспечению
Для обеспечения функционирования программного средства необходи-мо предварительно установить на компьютере:
­	Android Studio.
­	Oracle jdk-11.0.2.
5.2	Требования к аппаратному обеспечению
Для обеспечения функционирования программного средства необходи-мы эти параметры:
­	количество свободного места на физическом накопителе не меньше 20 МБ;
­	количество оперативной памяти не меньше 1 ГБ;
­	частота процессоров не ниже 1.5 Гигагерц.
5.3	Требования к надёжности
К программному средству предъявляются следующие требования в плане надёжности:
­	вводимые данные должны подвергаться проверке на корректность;
­	ввод некорректных данных пользователем должен корректно обрабаты-ваться (предоставление выбора между вводом корректных данных и вы-ходом из программы)
5.4	Требования к безопасности
Скрывать местоположение пользователя.
6	ХАРАКТЕРИСТИКА ВЫБРАННЫХ ПРОГРАММНЫХ СРЕД И СРЕДСТВ
6.1	Программные среды
К программным средам относятся приложения позволяющие создавать продукт:
­	Android Studio — это интегрированная среда разработки (IDE) для работы с платформой Android, анонсированная 16 мая 2013 года на конференции Google 
­	Android — операционная система для смартфонов, планшетов, элек-тронных книг, цифровых проигрывателей, наручных часов, фит-нес-браслетов, игровых приставок, ноутбуков, нетбуков, смартбуков, очков Google Glass, телевизоров и других устройств.
­	GitHub — крупнейший веб-сервис для хостинга IT-проектов и их совместной разработки.

6.2	Программные средства.
К программным средствам относятся готовые приложения которые можно использовать для создания других, более функциональных:
­	Карты Google — набор приложений, построенных на основе плат-ного картографического сервиса и технологии, предоставляемых компанией Google. 
­	Aviasales.ru — российский поисковик авиабилетов, принадлежащий компании Go Travel Un Limited, основателем которой был Констан-тин Калинов. Ежемесячная аудитория сервиса оценивается в около 7 миллионов человек. 
­	OpenWeatherMap — онлайн сервис, который предоставляет платный для доступа к данным о текущей погоде, прогнозам, для web-сервисов и мобильных приложений. Архивные данные доступны только на коммерческой основе. В качестве источника данных ис-пользуются официальные метеорологические службы, данные из ме-теостанций аэропортов, и данные с частных метеостанций.
7	ВХОДНЫЕ И ВЫХОДНЫЕ ДАННЫЕ
Входными данными для программы являются сформированные запросы в формате строки и данные о количестве персон, а так же данные о интересу-ющем периоде времени .
Выходными данными после обработки будут:
Карта с маркерами и рейтингом отеля (отмечены будут выбранные отели по заданным параметрам). 
