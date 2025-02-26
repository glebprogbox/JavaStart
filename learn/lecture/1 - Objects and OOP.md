# Про JVM, JRE, JDK
JVM (Java Virtual Machine) — это виртуальная машина, созданная для исполнения кода на языке программирования Java. В ней происходит трансляция и исполнение байткода Java, который является промежуточным языком, сгенерированным компилятором Java. JVM обеспечивает портируемость Java-приложений, то есть они могут запускаться на различных операционных системах, поддерживающих JVM. Каждая операционная система имеет свою реализацию JVM, например, Oracle JVM, OpenJDK, GraalVM. JVM включена в JRE.

JRE (Java Runtime Environment) — это часть Java Development Kit (JDK), которая содержит все необходимое для исполнения Java-приложений, но не включает в себя инструменты разработки, такие как компилятор (javac) и архиватор (jar). JRE состоит из JVM, стандартной библиотеки Java и компонентов, необходимых для исполнения кода, написанного на Java.
Когда вы устанавливаете JRE на своем компьютере, вы получаете возможность запускать Java-приложения, но не можете создавать новые или компилировать существующие. Для полноценной разработки Java-приложений необходимо установить JDK, который включает в себя все компоненты JRE, а также инструменты разработки.

JDK (Java Development Kit) — это полный набор инструментов для разработки приложений на языке программирования Java. JDK включает в себя все компоненты JRE (Java Runtime Environment), а также дополнительные инструменты и библиотеки, необходимые для создания, компиляции и тестирования Java-приложений.
Основные компоненты JDK:
JRE: включает в себя JVM (Java Virtual Machine) и стандартную библиотеку Java, необходимые для исполнения Java-приложений.
Java Compiler (javac): инструмент для компиляции Java-кода в байткод, который может быть исполнен JVM.
Java Archive (jar): инструмент для архивации Java-классов, ресурсов и манифестов в один файл.
JavaDoc: генератор документации для Java-приложений, который создает HTML-документацию на основе комментариев в исходном коде.
Java Debugger (jdb): инструмент для отладки Java-приложений.
Java Archiver (jar): инструмент для архивации Java-классов, ресурсов и манифестов в один файл.
Java Network Launch Protocol (jnlp): инструмент для запуска Java-приложений через веб-браузер.
Java Plugin: плагин для веб-браузера, который позволяет запускать Java-приложения в веб-страницах.
JDK доступен для различных операционных систем, таких как Windows, macOS и Linux, и может быть загружен с официального сайта Oracle или других поставщиков, таких как OpenJDK. Чтобы начать разработку Java-приложений, необходимо установить JDK и настроить среду разработки, например, IntelliJ IDEA, Eclipse или NetBeans.
Стабильная сейчас версия JDK - 21.

Для разработки используем IntelliJ IDEA + github/gitlab.

# Про память
JVM память делиться на:
Heap - любые объекты. Как уронить - создать много объектов, будет ошибка Out.of.memory
В heap хранятся также пуллы для ссылочных переменных (String пул и тп), те в heap все ссылки.
Stack - хранит примитивы и последовательность методов. Как уронить - сделать бесконечный цикл с методом. Будет ошибка StackOverflowError

# Имутабельность, объекты, ссылки
Иммутабельность важна для коллекций (пройдем позже).
String S1 = "abc";
String S2 = "abc";

Равенство будет, тут мы экономим память в heap (Ява сама экономит), ссылка будет одна и та же. Потому что ява нашел в String pool строку abc и присвоил для S2 такую же ссылку на эту строку, те  обе переменные ссылаются на одну и ту же строку "abc", которая уже существует в пуле строк, S1 и S2 будут считаться равными.
В Java, две строковые переменные, созданные с помощью ключевого слова String, считаются равными, если они ссылаются на один и тот же объект String в пуле строк. Пул строк — это область памяти, где хранятся уже созданные строки, чтобы можно было переиспользовать их и сэкономить память.
Чтобы проверить кейс, можно использовать оператор == или метод equals():
String S1 = "abc";
String S2 = "abc";
if (S1 == S2) {
    System.out.println("S1 и S2 ссылаются на один и тот же объект");
}
if (S1.equals(S2)) {
    System.out.println("Значения S1 и S2 равны");
}

Оба выражения вернут true, так как S1 и S2 ссылаются на один и тот же объект String и имеют одинаковое значение.

Однако, если бы мы создали строки с помощью new оператора, как в примере ниже, то S1 и S2 ссылались бы на разные объекты, и оператор == вернул бы false:
String S1 = new String("abc");
String S2 = new String("abc");
if (S1 == S2) {
    System.out.println("S1 и S2 ссылаются на один и тот же объект"); //false
}
if (S1.equals(S2)) {
    System.out.println("Значения S1 и S2 равны"); //true
}

В этом случае, только метод equals() вернет true, так как значения строк одинаковы, но объекты разные.

== работает для сравнения ссылочных типов, но оператор сравнивает именно ссылки на объекты, а не сами объекты
есть еще equals, он изначально работает как и == , но если переопределить метод, то можно сравнивать именно объекты, а не ссылки.


# ООП
Коротко
Инкапсуляция - это про модификаторы доступов, чтобы не все могли изменять какие-то важные объекты / переменные
Абстракция - это описание без деталей
Наследование - переход к деталям, от абстрактного или не абстрактного класса
Абстрактые классы есть в Java, начинаются с Abstract
Полиморфизм - смена поведения (переопределение)

Важно - предок может быть только один
В Java, каждый класс имеет только одного непосредственного предка (суперкласса), что соответствует принципу наследования в объектно-ориентированном программировании (ООП). Этот принцип называется "один суперкласс" (Single Inheritance).
Принцип "один суперкласс" гарантирует, что иерархия наследования классов в Java является строгой и упорядоченной. Каждый класс в Java может наследовать атрибуты и методы только от одного другого класса (кроме Object, который является корневым классом иерархии всех классов в Java).
Этот принцип также позволяет избежать неоднозначностей и конфликтов, которые могут возникнуть при наличии нескольких предков (многонаследия, Multiple Inheritance), когда два или более предка определяют один и тот же метод или атрибут.
Однако, чтобы преодолеть некоторые ограничения "один суперкласс", Java вводит интерфейсы (Interfaces) и наследование от нескольких интерфейсов (Multiple Inheritance of Types). Интерфейсы позволяют классу реализовывать несколько типов, не нарушая принцип "один суперкласс".
Важно - любой класс зависит от класса object. Это суперкласс.

Java в целом не полностью про ООП, т.к. есть еще и примитивы (int, double и тп).

# ДЗ
- поправить программу с имутабельным классом, при изменении объекта должен создаваться новый объект с этими данными
- погрузиться в ООП, понять принципы, продемонстрировать принципы ООП на примере автомобилей

Полезная литра - Java. Библиотека профессионала, том 1. Основы. 11-е издание Кей Хорстманн
