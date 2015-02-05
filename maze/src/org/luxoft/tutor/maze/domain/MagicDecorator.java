package org.luxoft.tutor.maze.domain;

import org.luxoft.tutor.mazeframework.domain.MapSite;
import org.luxoft.tutor.mazeframework.domain.MapSiteDecorator;
import org.luxoft.tutor.mazeframework.domain.Player;

import static java.lang.String.format;

public class MagicDecorator extends MapSiteDecorator {

    private final MapSite site;

    public static MagicDecorator magic(MapSite site) {
        assert site != null;
        return new MagicDecorator(site);
    }

    private MagicDecorator(MapSite site) {
        this.site = site;
    }

    @Override
    public void enter(Player player) {
        player.visit(this);
        player.hit(1);
    }

    @Override
    public String asString() {
        return format("Magic %s", site.asString());
    }
}
