package touhou.enemies;
import basic.GameObject;
import basic.physics.BoxCollider;
import touhou.Player;

public class PlayerDamage {
    public void run(Enemy owner){
        BoxCollider boxCollider=owner.boxCollider;
      Player player=GameObject.collideWith(boxCollider,Player.class);
      if(player!=null){
          player.getHit();
          owner.isActive=false;
      }

    }
    public void otherRun(EnemiesSuper owner) {

        BoxCollider boxCollider = owner.boxCollider;
        Player player = GameObject.collideWith(boxCollider, Player.class);
        if (player != null) {
            player.getHit();
            owner.isActive = false;
        }
    }
}
