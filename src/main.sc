require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: start || sessionResult = "Сценарий начинается отсюда", sessionResultColor = "#143AD1"
        q!: $regex</start>
        image: https://248305.selcdn.ru/zfl_prod/1000088569/272167484/2MqfYFaxigfxWyT1.jpg
        a: Добрый день! Я виртуальный секретарь О!Ресурс. Кем бы Вы хотели стать?🤔 || htmlEnabled = false, html = "Добрый день! Я виртуальный секретарь О!Ресурс. Кем бы Вы хотели стать?🤔"
        buttons:
            "Наставник" -> /Вопрос2_нст
            "Обучающийся" -> /В2_ст
        intent: /Наставник || toState = "/Вопрос2_нст"
        intent: /Обучающийся || toState = "/В2_ст"
        intent: /sys/aimylogic/ru/parting || onlyThisState = false, toState = "/Bye"
        event: noMatch || toState = "/start"

    state: Bye
        a: Пока-пока! 👋
        buttons:
            "Начать" -> /start
        event: noMatch || toState = "/Bye"
        intent: /sys/aimylogic/ru/parting || toState = "/Bye"

    state: Вопрос2_нст
        a: Есть ли у вас свободное время?
        buttons:
            "Да ✅ " -> /Вопрос3_нст
            "Нет ❌ " -> /Альт3_нск
        intent: /sys/aimylogic/ru/parting || toState = "/Bye"

    state: Вопрос3_нст
        a: Нравится ли Вам делиться опытом?
        buttons:
            "Да ✅ " -> /Вопрос4_нст
            "Нет ❌ " -> /Вопрос4_нст
        intent: /sys/aimylogic/ru/parting || toState = "/Bye"
        event: noMatch || toState = "/Вопрос3_нст"

    state: Вопрос4_нст
        a: Любите ли Вы общаться с людьми?
        buttons:
            "Да ✅ " -> /Вопрос5_нст
            "Нет ❌ " -> /Альт5_нск
        intent: /sys/aimylogic/ru/parting || toState = "/Bye"
        event: noMatch || toState = "/Вопрос4_нст"

    state: Вопрос5_нст
        a: Есть ли у Вас опыт наставничества?
        buttons:
            "Да ✅ " -> /Конец_нст
            "Нет ❌ " -> /AЛЬТконец_нск
        intent: /sys/aimylogic/ru/parting || toState = "/Bye"
        event: noMatch || toState = "/Вопрос5_нст"

    state: Конец_нст
        a: Отлично! Из Вас выйдет хороший наставник! Регистрируйтесь. (ссылка на платформу)
        go!: /Bye
        intent: /sys/aimylogic/ru/parting || toState = "/Bye"
        event: noMatch || toState = "/Start"

    state: Альт3_нск
        a: Нравится ли Вам делиться опытом?
        buttons:
            "Да ✅ " -> /Вопрос4_нст
            "Нет ❌ " -> /Альт4_нск
        intent: /sys/aimylogic/ru/parting || toState = "/Bye"
        event: noMatch || toState = "/Альт3_нск"

    state: Альт4_нск
        a: Любите ли Вы общаться с людьми?
        buttons:
            "Да ✅ " -> /Альт5_нск
            "Нет ❌ " -> /Альт5_нск
        intent: /sys/aimylogic/ru/parting || toState = "/Bye"
        event: noMatch || toState = "/Альт4_нск"

    state: Альт5_нск
        a: Есть ли у Вас опыт наставничества?
        buttons:
            "Да ✅ " -> /AЛЬТконец_нск
            "Нет ❌ " -> /AЛЬТконец_нск
        intent: /sys/aimylogic/ru/parting || toState = "/Bye"
        event: noMatch || toState = "/Альт5_нск"

    state: AЛЬТконец_нск
        a: Прекрасно, но кажется Вам необходимо ещё развить свои навыки в роли участника нашей платформы. Регистрируйтесь. (ссылка на платформу)
        go!: /Bye
        intent: /sys/aimylogic/ru/parting || toState = "/Bye"
        event: noMatch || toState = "/Start"

    state: В2_ст
        a: Есть ли у вас свободное время?
        buttons:
            "Да ✅ " -> /В3_ст
            "Нет ❌ " -> /В3_ст
        intent: /sys/aimylogic/ru/parting || toState = "/Bye"
        event: noMatch || toState = "/В2_ст"

    state: В3_ст
        a: Часто ли вы пользуетесь советами, которые вам дают? 
        buttons:
            "Да ✅ " -> /В4_ст
            "Нет ❌ " -> /В4_ст
        intent: /sys/aimylogic/ru/parting || toState = "/Bye"
        event: noMatch || toState = "/В3_ст"

    state: В4_ст
        a: Готовы ли вы работать над своими ошибками?
        buttons:
            "Да ✅ " -> /В5_ст
            "Нет ❌ " -> /В5_ст
        intent: /sys/aimylogic/ru/parting || toState = "/Bye"
        event: noMatch || toState = "/В4_ст"

    state: В5_ст
        a: Был ли у вас наставник? 
        buttons:
            "Да ✅ " -> /К_ст
            "Нет ❌ " -> /К_ст
        intent: /sys/aimylogic/ru/parting || toState = "/Bye"
        event: noMatch || toState = "/В5_ст"

    state: К_ст
        a: Отлично! У нас есть для Вас наставник! Регистрируйтесь. (ссылка на платформу)
        go!: /Bye
        intent: /sys/aimylogic/ru/parting || toState = "/Bye"
        event: noMatch || toState = "/К_ст"