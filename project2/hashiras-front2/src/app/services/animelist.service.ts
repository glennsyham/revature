import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { List } from '../models/list';

@Injectable({
  providedIn: 'root'
})
export class AnimelistService {


  // constructor injection
  constructor(private http: HttpClient) { }
  public getListByUserIdAndStatus(user_id: number, status: string): Observable<List[]> {
    return this.http.get(`${environment.serverApiUrl}/anime/user/${user_id}/status/${status}`).pipe(
      map(
        response => response as List[]
      )
    );
  }


  public getListByUserId(user_id: number): Observable<List[]> {
    return this.http.get(`${environment.serverApiUrl}/anime/user/${user_id}`).pipe(
      map(
        response => response as List[]
      )
    );
  }
  public searchList(anime_id: number): Observable<List[]> {
    return this.http.get(`${environment.animeApiUrl}/anime/${anime_id}`).pipe(
      map(
        response => response as List[]
      )
    );
  }
  public browseBySeason(year: number, season: number): Observable<List[]> {
    return this.http.get(`${environment.animeApiUrl}/seasons/${year}/${season}`).pipe(
      map(
        response => response as List[]
      )
    );
  }
  public browseByGenre(genre: string): Observable<List[]> {
    return this.http.get(`${environment.animeApiUrl}/anime/genre/${genre}`).pipe(
      map(
        response => response as List[]
      )
    );
  }
}
