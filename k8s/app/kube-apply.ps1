Write-Host "Applying Todo App YAML files..." -ForegroundColor Green
kubectl apply -f app-configmap.yaml
kubectl apply -f todo-secret.yaml
kubectl apply -f todo-deployment.yaml
kubectl apply -f todo-service.yaml
Write-Host "Todo App configurations applied successfully." -ForegroundColor Green 