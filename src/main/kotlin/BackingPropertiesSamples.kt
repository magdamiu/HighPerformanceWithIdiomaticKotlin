class Button {
    private var _text: String? = null
    var text: String
        set(value) {
            println(value)
            _text = value
        }
        get() {
            return _text + _text
        }

    fun printText() {
        println(_text)
    }
}

