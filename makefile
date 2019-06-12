# Development environment with nREPL middleware

# Dev is a phony target since it doesn't produce a file
.PHONY: dev
dev:
	clojure -A:cider:test-paths

.PHONY: test
test:
	bin/kaocha --watch --fail-fast
