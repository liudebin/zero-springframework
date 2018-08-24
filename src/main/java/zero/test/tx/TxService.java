package zero.test.tx;

/**
 * @author liuguobin
 * @date 2018/7/25
 */

public class TxService {
    TxTest txTest;

    public TxTest getTxTest() {
        return txTest;
    }

    public TxService setTxTest(TxTest txTest) {
        this.txTest = txTest;
        return this;
    }
}
