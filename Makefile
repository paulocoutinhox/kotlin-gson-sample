# tasks
.PHONY: help
help:      ## Show The Help
	@echo "Usage: make <target>"
	@echo ""
	@echo "Targets:"
	@fgrep "##" Makefile | fgrep -v fgrep

.PHONY: clear
clear:     ## Clear Temporary Files
	rm -rf build

.PHONY: build
build:     ## Build Project
	./gradlew build

.PHONY: run
run:       ## Run Project
	./gradlew run

