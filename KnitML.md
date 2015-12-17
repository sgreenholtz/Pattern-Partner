# KnitML Tags

Referenced from: http://www.knitml.com/docs/users-guide.html

| Tag | Description | Etc. |
| --- | ----------- | ---------- | 
| ball-weight | The weight of a single ball of yarn. | `<ball-weight unit='g'>50</ball-weight>` | 
| bind-off | Bind off specificed number of stitches | `<bind-off>50</bind-off>` |
| bind-off-all | Bind off all stitches on needles | `<bind-off-all />` |
| cast-on | Cast the number of stitches onto the current needle. | |
| declare-flat-knitting | Declare begin knitting flat | `<declare-flat-knitting />` |
| declare-round-knitting | Declare begin knitting in the round | `<declare-round-knitting />` |
| decrease | Decrease using stitch of specified type | `<decrease type="k2tog" />` |
| directions | Pattern directions | |
| from-stitch-holder | Follow instructions following the stitch holder | |
| gauge | Instructions for the gauge | `<gauge type="stockinette">...</gauge>` |
| general-information | General information about the pattern | |
| increase | Increase using stitch of specified type | `<increase type="yo" />` |
| knit | Knit specified stitches or until end | `<knit>50</knit>` | 
|      |                                      | `<repeat until="end"><knit /></repeat>` |
| needle | Needle for use in pattern, size attribute in US numbers or mm | `<needle size="4mm" />` |
| purl | Purl specified stitches or until end | `<purl>2</purl>` |
| pattern | Pattern written in specified ISO language code | `<pattern xsl:lang="em">...</pattern>` |
| pick-up-stitches | Pick up stitches in indicated direction | `<pick-up-stitches type="purlwise">10</pick-up-stitches>` |
| place-marker | Place a stitch marker | `<place-marker />` |
| remove-marker| Remove a stitch marker | `<remove-marker />` |
| repeat | Repeat enclosed instructions specified number of times or until end | `<repeat until="times" value="3">...</repeat>`|

