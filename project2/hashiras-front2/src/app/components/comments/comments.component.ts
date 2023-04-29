import { Component, OnInit, Input } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { CommentService } from 'src/app/services/comment.service';
import { Comment } from '../../models/comment';
import { FavoritesComponent } from '../favorites/favorites.component';

@Component({
  selector: 'app-comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.css']
})
export class CommentsComponent implements OnInit {


  comments: Comment[];
  newComment: Comment;
  animeId: number;
  userId: number;
  @Input() animeInfo: any;


  constructor(private http: HttpClient, private cs: CommentService, private fav: FavoritesComponent) { }

  ngOnInit() {
    this.animeId = this.animeInfo.mal_id;
    this.userId = this.fav.loggedInUser.id;
    this.displayComments(this.animeId);
  }

  //this will reload when parent changes
  ngOnChanges() {
    this.animeId = this.animeInfo.mal_id;
    this.userId = this.fav.loggedInUser.id;
    this.displayComments(this.animeId);
  }

  submit(comment: string) {
    this.newComment = new Comment(this.animeId, this.userId, comment);
    // this.cs.addComment(this.newComment);
    this.cs.postComment(this.newComment).subscribe(data => {
      this.displayComments(this.animeId);
    }, error => {

    }
    );

  }


  displayComments(animeId: number) {
    console.log("display comments");

    console.log(this.fav.animeInfo.mal_id);
    this.cs.getCommentsByAnimeId(animeId).subscribe(data => {
      this.getComments(data);
    }
    );
  }
  getComments(data: any) {
    this.comments = data;

    //console.log(data);
    // this.comment.forEach(element => {
    //   console.log(element);
    //   this.username = element['author']['username'];
    //   this.commentText = element['comment'];
    // });
  }

}
