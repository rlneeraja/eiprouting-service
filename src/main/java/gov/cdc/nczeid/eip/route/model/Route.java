package gov.cdc.nczeid.eip.route.model;


import lombok.Data;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.Valid;

import java.util.Date;
import java.util.UUID;



@Data
@Entity
@Table(name="Route")
public class Route {
	
    @Id
    @ApiModelProperty(hidden=true, position=89) 
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name="Route_id", nullable = false, unique = true)
    private UUID routeId;
    
    
    @ApiModelProperty(required=true, value="Condition Code", example="10001", position=2) 
    @NotEmpty(message="Condition can not be empty")
    @Column(name="Condition", nullable = false)
    private String condition;
    
    @ApiModelProperty(required=true, value="Destination Route Name", example="FDD", position=3)
    @NotEmpty(message="Destination can not be empty")
    @Column(name="Destination")
    private String destination;
    
    @Column(name="Active")
    @ApiModelProperty(required=true, hidden=true, position=95)
    private Integer active = 1;
    
    @Column(name="created_datetime")
    @CreationTimestamp
	@ApiModelProperty(hidden=true, position=90)
    private Date createdDateTime;
    
    @UpdateTimestamp
	@ApiModelProperty(hidden=true, position=91)
    @Column(name="update_datetime")
    private Date updateDateTime;
    
	@ApiModelProperty(hidden=true, position=92)
    @Column(name="created_by")
    private String createdBy = "EIP_ROUTING_SERVICE";
    
	@ApiModelProperty(hidden=true, position=93)
    @Column(name="updated_by")
    private String updatedBy = "EIP_ROUTING_SERVICE";
	
	@ApiModelProperty(hidden=true, position=94)
    @Version
    @Column(name="version", columnDefinition = "integer DEFAULT 0", nullable = false)
    private long version = 0L;
    

}
