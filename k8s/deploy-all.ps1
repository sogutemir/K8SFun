Write-Host "=== PostgreSQL Kaynaklarını Oluşturma ===" -ForegroundColor Cyan
cd postgres
.\kube-apply.ps1
cd ..

Write-Host "=== Todo Uygulaması Kaynaklarını Oluşturma ===" -ForegroundColor Cyan
cd app
.\kube-apply.ps1
cd ..

Write-Host "=== Servis Durumlarını Kontrol Etme ===" -ForegroundColor Yellow
kubectl get pods
kubectl get svc

Write-Host "Tüm Kubernetes kaynakları başarıyla uygulandı!" -ForegroundColor Green 