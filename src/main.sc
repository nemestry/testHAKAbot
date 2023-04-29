require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: start || sessionResult = "Сценарий начинается отсюда", sessionResultColor = "#143AD1"
        q!: $regex</start>
        image: https://248305.selcdn.ru/zfl_prod/1000088569/272167484/2MqfYFaxigfxWyT1.jpg
        a: Добрый день! Я виртуальный секретарь О!Ресурс. Кем бы Вы хотели стать? || htmlEnabled = false, html = "Добрый день! Я виртуальный секретарь О!Ресурс. Кем бы Вы хотели стать?"
        buttons:
            "Наставник" -> /В2_нст
            "Обучающийся" -> /В2_ст
        intent: /Наставник || toState = "/В2_нст"
        intent: /Обучающийся || toState = "/В2_ст"
        intent: /sys/aimylogic/ru/parting || onlyThisState = false, toState = "/Bye"
        event: noMatch || toState = "/start"

    state: Bye
        a: Пока-пока!
        buttons:
            "Начать" -> /start
        event: noMatch || toState = "/Bye"
        intent: /sys/aimylogic/ru/parting || toState = "/Bye"

    state: В2_нст
        a: Есть ли у вас свободное время?
        buttons:
            "Да" -> /В3_нст
            "Нет" -> /al3_nsk
        intent: /sys/aimylogic/ru/parting || toState = "/Bye"
        event: noMatch || toState = "/В2_нст"

    state: В3_нст
        a: Нравится ли Вам делиться опытом?
        buttons:
            "Да" -> /В4_нст
            "Нет" -> /В4_нст
        intent: /sys/aimylogic/ru/parting || toState = "/Bye"
        event: noMatch || toState = "/В3_нст"

    state: В4_нст
        a: Любите ли Вы общаться с людьми?
        buttons:
            "Да" -> /В5_нст
            "Нет" -> /al5_nsk
        intent: /sys/aimylogic/ru/parting || toState = "/Bye"
        event: noMatch || toState = "/В4_нст"

    state: В5_нст
        a: Есть ли у Вас опыт наставничества?
        buttons:
            "Да" -> /К_нст
            "Нет" -> /alen_nsk
        intent: /sys/aimylogic/ru/parting || toState = "/Bye"
        event: noMatch || toState = "/В5_нст"

    state: К_нст
        a: Отлично! Из Вас выйдет хороший наставник! Регистрируйтесь. 
            Ссылка: http://banaworld.ru:22222/
        go!: /Bye
        intent: /sys/aimylogic/ru/parting || toState = "/Bye"
        event: noMatch || toState = "/Start"

    state: al3_nsk
        a: Нравится ли Вам делиться опытом?
        buttons:
            "Да" -> /В4_нст
            "Нет" -> /al4_nsk
        intent: /sys/aimylogic/ru/parting || toState = "/Bye"
        event: noMatch || toState = "/al3_nsk"

    state: al4_nsk
        a: Любите ли Вы общаться с людьми?
        buttons:
            "Да" -> /al5_nsk
            "Нет" -> /al5_nsk
        intent: /sys/aimylogic/ru/parting || toState = "/Bye"
        event: noMatch || toState = "/al4_nsk"

    state: al5_nsk
        a: Есть ли у Вас опыт наставничества?
        buttons:
            "Да" -> /alen_nsk
            "Нет" -> /alen_nsk
        intent: /sys/aimylogic/ru/parting || toState = "/Bye"
        event: noMatch || toState = "/al5_nsk"

    state: alen_nsk
        a: Прекрасно, но кажется Вам необходимо ещё развить свои навыки в роли участника нашей платформы. Регистрируйтесь. 
            Ссылка: http://banaworld.ru:22222/
        go!: /Bye
        intent: /sys/aimylogic/ru/parting || toState = "/Bye"
        event: noMatch || toState = "/Start"

    state: В2_ст
        a: Есть ли у вас свободное время?
        buttons:
            "Да" -> /В3_ст
            "Нет" -> /В3_ст
        intent: /sys/aimylogic/ru/parting || toState = "/Bye"
        event: noMatch || toState = "/В2_ст"

    state: В3_ст
        a: Часто ли вы пользуетесь советами, которые вам дают?
        buttons:
            "Да" -> /В4_ст
            "Нет" -> /В4_ст
        intent: /sys/aimylogic/ru/parting || toState = "/Bye"
        event: noMatch || toState = "/В3_ст"

    state: В4_ст
        a: Готовы ли вы работать над своими ошибками?
        buttons:
            "Да" -> /В5_ст
            "Нет" -> /В5_ст
        intent: /sys/aimylogic/ru/parting || toState = "/Bye"
        event: noMatch || toState = "/В4_ст"

    state: В5_ст
        a: Был ли у вас наставник?
        buttons:
            "Да" -> /К_ст
            "Нет" -> /К_ст
        intent: /sys/aimylogic/ru/parting || toState = "/Bye"
        event: noMatch || toState = "/В5_ст"

    state: К_ст
        a: Отлично! У нас есть для Вас наставник! Регистрируйтесь. (ссылка на платформу)
        go!: /Bye
        intent: /sys/aimylogic/ru/parting || toState = "/Bye"
        event: noMatch || toState = "/К_ст"