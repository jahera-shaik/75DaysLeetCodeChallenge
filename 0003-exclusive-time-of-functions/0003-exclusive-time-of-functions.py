class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        ans = [0] * n
        stack = []
        prev_time = 0

        for log in logs:
            fn_id, typ, time = log.split(':')
            fn_id = int(fn_id)
            time = int(time)

            if typ == "start":
                if stack:
                    ans[stack[-1]] += time - prev_time

                stack.append(fn_id)
                prev_time = time

            else:  # end
                ans[stack.pop()] += time - prev_time + 1
                prev_time = time + 1

        return ans