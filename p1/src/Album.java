public class Album {
    private String title;
    private String artist;
    private Genre genre;
    private Date releaseDate;
    private boolean isAvailable;

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Album) {
            Album album = (Album) obj;
            if(album.title.equals(this.title)&&album.artist.equals(this.artist)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        //gotta check that this works with genre and releasedate, et.
        String a = this.title;
        String b =this.artist;
        String c = this.genre.toString();
        String d = releaseDate.toString();
        return(a+"::"+b+"::"+c+"::"+d+"::"+this.isAvailable);
    }
}