Write-Host "Applying PostgreSQL YAML files..." -ForegroundColor Green
kubectl apply -f postgres-secret.yaml
kubectl apply -f postgres-deployment.yaml
kubectl apply -f postgres-service.yaml
Write-Host "PostgreSQL configurations applied successfully." -ForegroundColor Green 