package org.kosa.myproject.test3;

public class Youtube implements Player {
	public Youtube() {
		System.out.println("유투브를 실행합니다.");
	}

	@Override
	public void play() {
		System.out.println("유투브 동영상을 재생하다.");
	}
	
}
