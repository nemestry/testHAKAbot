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
            
    
    
    
