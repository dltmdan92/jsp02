package config;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//요청에 앞서 선처리되는 코드
@WebFilter("/*")
public class EncodingFilter implements Filter {

	private String setEncodingSet = "utf-8";
	
    public EncodingFilter() {
        
    }

	public void destroy() {
		// 웹서버가 꺼질때 실행되는 코드
		System.out.println("destroy...");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 페이지 등을 호출할 떄 매번 이 메서드가 실행되고 호출이 된다.
		System.out.println("필터 호출...");
		
		request.setCharacterEncoding(setEncodingSet);
		
		chain.doFilter(request, response);
		// 필터 작업이 끝났고 이제 로직실행하기위해 호출하는 메서드
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// 필터가 처음에 초기화될떄, 웹 서버 시작시 필터가 초기화되는데 이때 호출
		System.out.println("init...");
	}

}
