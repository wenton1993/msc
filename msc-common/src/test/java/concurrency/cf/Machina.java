package concurrency.cf;

/**
 * 一个简单的状态机, 通过work移动状态, 到END时打印状态机的id和状态
 */
public class Machina {

    // 状态
    public enum State {
        START, ONE, TWO, THREE, END;

        State step() {
            if (equals(END))
                return END;
            // 返回当前枚举值后面的一个值
            return values()[ordinal() + 1];
        }
    }

    private State state = State.START;
    private final int id;

    public Machina(int id) {
        this.id = id;
    }

    public static Machina work(Machina m) {
        // 判断状态是否是END. 如果是就睡眠, 如果不是就打印m的id和状态
        if (!m.state.equals(State.END)) {
            new Nap(0.1);
            m.state = m.state.step();
        }
        System.out.println(m);
        return m;
    }

    @Override
    public String toString() {
        return "Machina" + id + ": " + (state.equals(State.END) ? "complete" : state);
    }

}
