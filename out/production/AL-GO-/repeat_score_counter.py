import datetime
import pandas as pd

def compute_score(problem_id,time_taken, avg_time, hints_used, max_hints, optimization,prev_interval):
    time_score = max(0, 1 - time_taken / avg_time)
    hint_score = 1 - hints_used / max_hints
    opt_score = optimization  # 1, 0.5, 0
    return 100 * (0.5 * time_score + 0.3 * hint_score + 0.2 * opt_score)

def next_review(score, prev_interval):
    if score >= 80:
        return prev_interval * 2
    elif score >= 50:
        return prev_interval * 1.5
    else:
        return 1

# Example entry
problem = {
    "problem_id": "647",
    "time_taken": 83,
    "avg_time": 45,
    "hints_used": 3,
    "max_hints": 3,
    "optimization": 1,
    "prev_interval": 2
}

score = compute_score(**problem)
interval = next_review(score, problem["prev_interval"])
next_date = datetime.date.today() + datetime.timedelta(days=interval)
print(f"Score: {score:.2f}, Review again on: {next_date}")
