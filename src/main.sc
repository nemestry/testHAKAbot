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
        intent: /sys/ru/aimylogic/parting || onlyThisState = false, toState = "/Bye"
        event: noMatch || toState = "./"

    state: Bye
        a: Пока-пока!
        EndSession: 
            actions = {}
            
    
    
    

    state: Вопрос2_нст
        a: Есть ли у Вас свободное время? || htmlEnabled = false, html = "Есть ли у Вас свободное время?"
        buttons:
            " Да" -> /Вопрос2_нст/Вопрос3_нст
            "Нет" -> /Вопрос3_нст
        event: telegramAnyMessage || onlyThisState = true, toState = "/Вопрос2_нст"
        event: noMatch || toState = "./"

        state: Вопрос3_нст
            a: Нравится ли Вам делиться опытом?
            buttons:
                "Да" -> /Вопрос2_нст/Вопрос3_нст/Вопрос4_нст
                "Нет"

            state: Вопрос4_нст
                a: Любите ли Вы общаться с людьми?
                buttons:
                    "Да" -> /Вопрос2_нст/Вопрос3_нст/Вопрос4_нст/Вопрос5_нст
                    "Нет"

                state: Вопрос5_нст
                    a: Есть ли у Вас опыт наставничества?
                    buttons:
                        "Да" -> /Вопрос2_нст/Вопрос3_нст/Вопрос4_нст/Вопрос5_нст/Конец_нст
                        "Нет"

                    state: Конец_нст
                        a: Отлично! Из Вас выйдет хороший наставник! Регистрируйтесь. (ссылка на платформу)