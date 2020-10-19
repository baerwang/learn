package com.baerwang.command;

/**
 * 命令模式（Command Pattern）
 * 将来自客户端的请求传入一个对象，从而使你可用不同的请求对客户进行参数化。用于“行为请求者“与”行为实现者"解耦，
 * 可实现二者之间的松耦合，以便适应变化。分离变化与不变的因素。
 * 在面向对象的程序设计中，一个对象调用另一个对象，一般情况下的调用过程是：创建目标对象实例；设置调用参数；调用目标对象的方法。
 * 但在有些情况下又必要使用一个专门的类对这种调用过程加以封装，我们把这种专门的类称作command类。
 * Command模式可应用于：
 * a)整个调用过程比较繁杂，或者存在多处这种调用。这时，使用Command类对该调用加以封装，便于功能的再利用。
 * b)调用前后需要对调用参数进行某些处理。
 * c)调用前后需要进行某些额外处理，比如日志，缓存，记录历史操作等。
 * <p>
 * Command模式效果：
 * a)将调用操作的对象和知道如何实现该操作的对象解耦。
 * b)Command是头等对象。他们可以像其他对象一样被操作和扩展。
 * c)你可将多个命令装配成一个符合的命令。
 * d)增加新的command很容易，无需改变现有的类。
 * <p>
 * https://www.cnblogs.com/devinzhang/archive/2012/01/06/2315235.html
 *
 * @author baerwang
 * @since 2020/10/19 14:38
 */
public class CommandTest {

    public static void main(String[] args) {
        // 命令接收者
        Tv tv = new Tv();
        // 开机命令
        CommandOn commandOn = new CommandOn(tv);
        // 关闭命令
        CommandOff commandOff = new CommandOff(tv);
        // 切换频道
        CommandChange commandChange = new CommandChange(tv, 1);
        // 命令控制对象
        /*Control control = new Control(commandOn, commandOff, commandChange);

        // 开机
        control.turnOn();
        // 切换频道
        control.changeChannel();
        // 关机
        control.turnOff();*/

        Control control = new Control(commandOn);
        control.execute();
        control = new Control(commandChange);
        control.execute();
        control = new Control(commandOff);
        control.execute();

    }
}
