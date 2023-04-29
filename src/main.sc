require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start || sessionResult = "Сценарий начинается отсюда", sessionResultColor = "#143AD1"
        q!: $regex</start>
        image: https://248305.selcdn.ru/zfl_prod/64069/64072/Y6nDSc64tgJWac7N.png
        a: Добрый день! Я виртуальный секретарь О!РЕСУРС. Кем бы Вы хотели стать? || htmlEnabled = false, html = "Добрый день! Я виртуальный секретарь О!РЕСУРС. Кем бы Вы хотели стать?"
        buttons:
            "Наставник" -> /Вопрос2_нст
            "Обучающийся" -> /Форма для обучающегося
        intent: /Наставник || toState = "/Вопрос2_нст"
        intent: /Обучающийся || onlyThisState = false, toState = "/Часы работы"
        intent: /sys/aimylogic/ru/parting || onlyThisState = false, toState = "/Bye"
        event: noMatch || toState = "/Start"

    state: Bye
        a: Пока-пока!
        EndSession: 
            actions = {}

    state: Вопрос2_нст
        a: Есть ли у вас свободное время?
        buttons:
            "Да" -> /Вопрос3_нст
            "Нет"
        intent: /sys/aimylogic/ru/parting || toState = "/Bye"
        event: noMatch || toState = "/Вопрос2_нст"

    state: Вопрос3_нст
        a: Нравится ли Вам делиться опытом?
        buttons:
            "Да" -> /Вопрос4_нст
            "Нет"
        intent: /sys/aimylogic/ru/parting || toState = "/Bye"

    state: Вопрос4_нст
        a: Любите ли Вы общаться с людьми?
        buttons:
            "Да" -> /Вопрос5_нст
            "Нет"
        intent: /sys/aimylogic/ru/parting || toState = "/Bye"

    state: Вопрос5_нст
        a: Есть ли у Вас опыт наставничества?
        buttons:
            "Да" -> /Конец_нст
            "Нет"
        intent: /sys/aimylogic/ru/parting || toState = "/Bye"

    state: Конец_нст
        a: Отлично! Из Вас выйдет хороший наставник! Регистрируйтесь. (ссылка на платформу)
        go!: /Bye
        intent: /sys/aimylogic/ru/parting || toState = "/Bye"