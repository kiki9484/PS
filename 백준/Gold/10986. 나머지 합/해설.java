/*
(A[i] + ... + A[j]) % M = (S[j] - S[i-1]) % M = 0
(S[i-1] % M == S[j] % M)인 (i, j)쌍을 찾으면 된다.
cnt[k] : S[i] % M == K인 i의 개수
cnt[k] * (cnt[k] - 1) / 2를 통해 구할 수 있다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {      
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static int N, M;
    public static int[] A;
    public static int[] cnt;
    
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];
        cnt = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken()) % M;
        }
        System.out.println(solve());
    }
    
    public static long solve(){
        long ret = 0;
        int sum = 0;
        cnt[0]++;
        for(int i = 0; i < N; i++){
            sum += A[i];
            sum %= M;
            cnt[sum]++;
        }
        for(int i = 0; i < M; i++)
            ret += 1L * (cnt[i] * (cnt[i] - 1L)) / 2L;
        return ret;
    }
}
