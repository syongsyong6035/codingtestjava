package _20260214;


import static _20260214.MyLogger.log;
import static _20260214.ThreadUtils.sleep;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**당신은 커머스 회사의 주문 팀에 새로 입사했다.
주문 팀의 고민은 연동하는 시스템이 점점 많아지면서 주문 프로세스가 너무 오래 걸린다는 점이다.
하나의 주문이 발생하면 추가로 3가지 일이 발생한다.
재고를 업데이트 해야한다. 약 1초
배송 시스템에 알려야 한다. 약 1초
회계 시스템에 내용을 업데이트 해야 한다. 약 1초
각각 1초가 걸리기 때문에, 고객 입장에서는 보통 3초의 시간을 대기해야 한다.
    3가지 업무의 호출 순서는 상관이 없다. 각각에 주문 번호만 잘 전달하면 된다. 물론 3가지 일이 모두 성공해야 주문이
완료된다.
여기에 기존 코드가 있다. 기존 코드를 개선해서 주문 시간을 최대한 줄여보자.**/

public class OldOrderService {
  private final ExecutorService es = Executors.newFixedThreadPool(3);
  public void order(String orderNo) throws ExecutionException, InterruptedException {
    InventoryWork inventoryWork = new InventoryWork(orderNo);
    ShippingWork shippingWork = new ShippingWork(orderNo);
    AccountingWork accountingWork = new AccountingWork(orderNo);

    //멀티 스레드환경으로 일단 여러 작업을 동시에 실행하기


    //try -catch로 값 확인
    try{
      Future<Boolean> future1 = es.submit(inventoryWork);
      Future<Boolean> future2 = es.submit(shippingWork);
      Future<Boolean> future3 = es.submit(accountingWork);

      Boolean result1 = future1.get();
      Boolean result2 = future2.get();
      Boolean result3 = future3.get();
      // 결과 확인
      if (result2 && result1 && result3) {
        log("모든 주문 처리가 성공적으로 완료되었습니다.");
      }else{
        log("일부 작업이 실패했습니다");
      }

    }finally {
      es.shutdown();
    }
  }
  static class InventoryWork implements Callable<Boolean> {
    private final String orderNo;
    public InventoryWork(String orderNo) {
      this.orderNo = orderNo;
    }
    @Override
    public Boolean call(){
      log("재고 업데이트: " + orderNo);
      sleep(1000);
      return true;
    }
  }
  static class ShippingWork implements Callable<Boolean>{
    private final String orderNo;
    public ShippingWork(String orderNo) {
      this.orderNo = orderNo;
    }
    @Override
    public Boolean call() {
      log("배송 시스템 알림: " + orderNo);
      sleep(1000);
      return true;
    }
  }
  static class AccountingWork implements Callable<Boolean>{
    private final String orderNo;
    public AccountingWork(String orderNo) {
      this.orderNo = orderNo;
    }
    @Override
    public Boolean call() {
      log("회계 시스템 업데이트: " + orderNo);
      sleep(1000);
      return true;
    }
  }
}
