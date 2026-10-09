package cn.edu.sicnu.cs.stu.baixinyuan.myapplication

class ProgramAdviser {
    //模型：输入语言，返回建议字符串，字符串资源ID返回给Activity去拿文本
    fun getAdvice(lang:String):Int{
        return when(lang){
            "kotlin" -> R.string.new_text
            "java" -> R.string.new_text
            "python" -> R.string.new_text
            "c++" -> R.string.new_text
            else -> R.string.new_text
        }
    }
}