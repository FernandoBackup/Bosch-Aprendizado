import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { AdsComponent } from './components/ads/ads.component';

export const routes: Routes = [
    { path: '', redirectTo: 'home', pathMatch: 'full' },
    { path: 'home', component: HomeComponent },
    { path: '**', redirectTo: 'home' }
];
