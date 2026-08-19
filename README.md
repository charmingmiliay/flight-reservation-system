<h1>항공권 예매 프로그램</h1>
<h2>1. 탑승객 등록</h2>
<p>Function.register();</p>
<pre><code class="language-bash">  # 탑승객의 이름, 나이, 국적, 여권번호(Pxxxx), 목적지를 입력 받도록 한다. 
  # 모든 정보의 입력이 완료되면 입력된 탑승객의 정보를 순차적으로 출력한다.
  # 메뉴의 번호를 기입할 때 정수가 아닌 실수형 또는 문자형이 입력될 경우 예외로 간주하여 정수를 입력할 것을 사용자에게 다시 요구하고 예외처리한다.
  
</code></pre>
<p>관련 코드</p>
<pre><code>```java
//  System.out.println("=======입력된 탑승객의 정보=======");
    System.out.println("탑승객의 번호: " + ps.getPassengerNum());
    System.out.println("이름: " + ps.getName());
    System.out.println("나이: " + ps.getAge());
    System.out.println("등급: " + settingGrade(ps.getAge(), Grade.values()));
    System.out.println("국적: " + ps.getCountry());
    System.out.println("여권번호: " + ps.getPassportNum());
    System.out.println("도착지: " + ps.getArrivals());
```
</code></pre>
<h2>2. DB에 등록된 모든 탑승객 조회</h2>
<p>Function.showPassengers();</p>
<pre><code class="language-bash">    # 미리 저장하고 실행했던 PassengerList의 리스트를 생성하고, 
      생성된 리스트를 출력한다.
</code></pre>
<p>관련 코드</p>
<pre><code class="language-java">    public static void showPrintPassengers(PassengerDTO p){
          System.out.println("=======입력된 탑승객의 정보=======");
          System.out.println("탑승객의 번호: " + p.getPassengerNum());
          System.out.println("이름: " + p.getName());
          System.out.println("나이: " + p.getAge());
          System.out.println("등급: " + p.getGrade());
          System.out.println("국적: " + p.getCountry());
          System.out.println("여권번호: " + p.getPassportNum());
          System.out.println("도착지: " + p.getArrivals());
    }
</code></pre>
<h2>3. 탑승객 정보 수정</h2>
<p>-Function.renameInfo();</p>
<pre><code class="language-bash">    # 수정하고자 하는 탑승객의 번호를 입력받아,
      탑승객의 정보를 처음부터 다시 입력받도록 한다.
    # 입력받은 번호가 탑승객 리스트의 범위를 벗어나면 "해당 번호의 탑승객이 없습니다."를 출력한다.
    # 이때 수정된 리스트를 처음부터 끝까지 출력하도록 한다.

</code></pre>
<p>관련 코드</p>
<pre><code class="language-java">   public static void renameInfo() {
        List&lt;PassengerDTO&gt; passengers = pl.getReservation();

        System.out.print("수정할 탑승객 번호를 입력하세요 (목록 조회: 0): ");
        int passengerNum = sc.nextInt();
        sc.nextLine(); // nextInt 뒤 개행 제거

        if (passengerNum == 0) {
            showPassengers();
            return;
        }

        PassengerDTO selectedPassenger = null;

        for (PassengerDTO p : passengers) {
            if (p.getPassengerNum() == passengerNum) {
                selectedPassenger = p;
                break;
            }
        }

        if (selectedPassenger == null) {
            System.out.println("해당 번호의 탑승객이 없습니다.");
            return;
        }

        System.out.print("새 이름: ");
        selectedPassenger.setName(sc.nextLine());

        System.out.print("새 나이: ");
        selectedPassenger.setAge(sc.nextInt());
        sc.nextLine();

        selectedPassenger.setGrade(
                settingGrade(selectedPassenger.getAge(), Grade.values())
        );

        System.out.print("새 국적: ");
        selectedPassenger.setCountry(sc.nextLine());

        System.out.print("새 여권번호: ");
        selectedPassenger.setPassportNum(sc.nextLine());

        System.out.println("현재 항공의 결항으로 목적지가 한정되어있습니다. 아래 보기에서 선택 가능합니다.");
        System.out.println("United Kingdom, Philippines, Italy, Vietnam, Japan, China ");
        System.out.print("새 도착지: ");
        selectedPassenger.setArrivals(sc.nextLine());

        System.out.println("탑승객 정보가 수정되었습니다.");
        showPrintPassengers(selectedPassenger);
    }
    
</code></pre>
<h2>4. 탑승객 정보 삭제</h2>
<p>Function.removeInfo();</p>
<pre><code>```bash
# 삭제하고자 하는 탑승객의 번호를 입력받아 해당 인덱스의 리스트를 삭제한다.
# 이때 리스트 하나를 삭제하면 그 뒤의 리스트가 앞 번호로 당겨지게 된다.
# 삭제된 리스트를 제외한 나머지 리스트를 모두 출력한다.
```
</code></pre>
<p>관련 코드
```java
public static void removeInfo() {
List&lt;PassengerDTO&gt; passengers = pl.getReservation();</p>
<pre><code>    System.out.print("삭제할 데이터의 탑승객 번호를 입력하세요: ");
    int removeIndex = sc.nextInt() + 1;
    sc.nextLine(); // nextInt() 뒤 입력 버퍼 정리

    if (removeIndex &gt;= 0 &amp;&amp; removeIndex &lt; passengers.size()) {
        //삭제할 인덱스를 사용자로부터 입력받고, 그 입력받은 값은 passenger 리스트의 크기보다 작아야한다. 아닐경우 else문으로 전달.

        PassengerDTO removedPassenger = passengers.remove(removeIndex);
        //입력받은 인덱스에 맞는 리스트를 찾아 삭제한다. 이때 삭제된 리스트의 인덱스로 그 뒤의 인덱스들이 앞으로 당겨지게 된다.

        System.out.printf(
                "%d번 인덱스의 %s 데이터가 삭제되었습니다.%n",
                removeIndex,
                removedPassenger.getName()
        );
    } else {
        System.out.println("존재하지 않는 인덱스입니다.");
        /*PassengerDTO에 PassengerList 리스트가 생성되지 않았거나,
        * 리스트의 인덱스 범위를 벗어났을 경우 출력.*/

    }

    showPassengers(); //수정 후, 수정된 리스트를 모두 출력하는 showPassengers() 메소드를 호출한다.
}
```
</code></pre>
